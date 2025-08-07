package com.nigma.gymwise.GymWise.application;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nigma.gymwise.GymWise.domain.model.UserProfile;
import com.nigma.gymwise.GymWise.domain.port.IUserRepository;
import com.nigma.gymwise.GymWise.infrastucture.adapter.IUserCrudRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;
import lombok.Data;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserService {

    // [4] Métodos existentes de gestión de usuarios
    public UserProfile save(UserProfile userProfile) {
        return iUserRepository.save(userProfile);
    }

    public UserProfile findById(Integer id) {
        return iUserRepository.findById(id);
    }

    public List<UserProfile> findAll() {
        return iUserRepository.findAll();
    }

    public void deleteById(Integer id) {
        iUserRepository.deleteById(id);
    }

    public UserProfile findByEmail(String email){
        return iUserRepository.findByEmail(email);
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class WorkoutPlan {
        private PlanContainer plan;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class PlanContainer {
            private List<Week> semanas;
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Week {
            private int numero;
            private List<Day> dias;
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Day {
            private String nombre;
            private List<Exercise> ejercicios;
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Exercise {
            private String nombre;
            private String series;
            private String repeticiones;
            private String nota;
        }
    }

    private final IUserRepository iUserRepository;
    private final IUserCrudRepository iUserCrudRepository;
    private final JavaMailSender javaMailSender;
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Pattern numberPattern = Pattern.compile("\\d+");

    @Value("${gemini.api.key}")
    private String apiKey;

    private final String PROMPT = """
    Genera un plan de entrenamiento de 4 semanas para:
    - Edad: %d años
    - Peso: %.1f kg
    - Objetivo: %s
    - Limitaciones: %s

    Reglas estrictas:
    1. Los campos series y repeticiones DEBEN contener SOLO números en formato "X" o "X-Y"
    2. Ejemplo válido: "series": "3", "repeticiones": "8-12"
    3. Estructura JSON exacta:
    {
        "plan": {
            "semanas": [
                {
                    "numero": 1,
                    "dias": [
                        {
                            "nombre": "Día ejemplo",
                            "ejercicios": [
                                {
                                    "nombre": "Ejercicio",
                                    "series": "3",
                                    "repeticiones": "8-12",
                                    "nota": "Texto opcional"
                                }
                            ]
                        }
                    ]
                }
            ]
        }
    }
    4. Usar siempre comillas dobles
    5. No incluir markdown ni texto adicional
    """;

    public UserService(IUserRepository iUserRepository,
                       IUserCrudRepository iUserCrudRepository,
                       JavaMailSender javaMailSender) {
        this.iUserRepository = iUserRepository;
        this.iUserCrudRepository = iUserCrudRepository;
        this.javaMailSender = javaMailSender;
    }

//    @Scheduled(cron = "0 */2 * * * ?")
    public void notificacionEmail() {
        System.out.println("Inicio de CRON");

        try {
            WorkoutPlan plan = generarPlan();
            procesarPlan(plan);

            List<String> emails = iUserCrudRepository.findEmailDateExpired();
            System.out.println("Emails obtenidos: " + emails);

            for(String email : emails) {
                enviarEmail(email, plan);
            }

        } catch (Exception e) {
            System.err.println("Error en generación de plan: " + e.getMessage());
        }
    }

    private void procesarPlan(WorkoutPlan plan) {
        for(WorkoutPlan.Week semana : plan.getPlan().getSemanas()) {
            for(WorkoutPlan.Day dia : semana.getDias()) {
                for(WorkoutPlan.Exercise ejercicio : dia.getEjercicios()) {
                    ejercicio.setSeries(extraerNumero(ejercicio.getSeries()));
                    ejercicio.setRepeticiones(extraerNumero(ejercicio.getRepeticiones()));
                }
            }
        }
    }

    private String extraerNumero(String input) {
        if(input == null) return "10";

        Matcher matcher = numberPattern.matcher(input);
        if(matcher.find()) {
            return matcher.group();
        }
        return "10"; // Valor por defecto si no encuentra números
    }

    private void enviarEmail(String email, WorkoutPlan plan) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Tu plan de entrenamiento");
        message.setText(construirMensaje(plan));

        javaMailSender.send(message);
        System.out.println("Email enviado a: " + email);
    }

    private String construirMensaje(WorkoutPlan plan) {
        StringBuilder sb = new StringBuilder();
        sb.append("¡Aquí está tu plan de entrenamiento!\n\n");

        for(WorkoutPlan.Week semana : plan.getPlan().getSemanas()) {
            sb.append("Semana ").append(semana.getNumero()).append(":\n");
            for(WorkoutPlan.Day dia : semana.getDias()) {
                sb.append("- ").append(dia.getNombre()).append(":\n");
                for(WorkoutPlan.Exercise ejercicio : dia.getEjercicios()) {
                    sb.append("  * ").append(ejercicio.getNombre())
                            .append(" (").append(ejercicio.getSeries())
                            .append("x").append(ejercicio.getRepeticiones()).append(")");
                    if(ejercicio.getNota() != null) {
                        sb.append(" [Nota: ").append(ejercicio.getNota()).append("]");
                    }
                    sb.append("\n");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public WorkoutPlan generarPlan() throws JsonProcessingException {
        String promptPersonalizado = String.format(
                PROMPT,
                30,
                65.0,
                "Ganar masa muscular",
                "Asma, Rotura ligamento posterior en rodilla"
        );

        String rawResponse = enviarAGemini(promptPersonalizado);
        return parsearRespuesta(rawResponse);
    }

    private String enviarAGemini(String prompt) {
        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + apiKey;

        String requestBody = String.format("""
            {
                "contents": [{
                    "parts": [{
                        "text": "%s"
                    }]
                }]
            }
            """, prompt.replace("\"", "\\\""));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return restTemplate.postForObject(
                url,
                new HttpEntity<>(requestBody, headers),
                String.class
        );
    }

    private WorkoutPlan parsearRespuesta(String jsonResponse) throws JsonProcessingException {
        // Limpieza básica de la respuesta
        String cleanedResponse = jsonResponse
                .replace("```json", "")
                .replace("```", "")
                .trim();

        JsonNode rootNode = objectMapper.readTree(cleanedResponse);
        String content = rootNode.path("candidates")
                .get(0)
                .path("content")
                .path("parts")
                .get(0)
                .path("text")
                .asText();

        // Limpieza adicional del contenido interno
        String cleanedContent = content
                .replace("```json", "")
                .replace("```", "")
                .trim();

        return objectMapper.readValue(cleanedContent, WorkoutPlan.class);
    }
}