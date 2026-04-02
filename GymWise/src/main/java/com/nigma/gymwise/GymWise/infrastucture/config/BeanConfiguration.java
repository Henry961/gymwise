package com.nigma.gymwise.GymWise.infrastucture.config;

import com.nigma.gymwise.GymWise.application.*;
import com.nigma.gymwise.GymWise.domain.port.*;
import com.nigma.gymwise.GymWise.infrastucture.adapter.IUserCrudRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class BeanConfiguration {

    @Bean
    public UserService usuarioService(IUserRepository iUserRepository, IUserCrudRepository iUserCrudRepository, JavaMailSender javaMailSender){
        return new UserService(iUserRepository,iUserCrudRepository, javaMailSender);
    }

    @Bean
    public UserMeasuresService userMeasuresService(IUserMeasuresRepository iUserMeasuresRepository){
        return new UserMeasuresService(iUserMeasuresRepository);
    }

    @Bean
    public UserBodyService userBodyService(IUserBodyRepository iUserBodyRepository){
        return new UserBodyService(iUserBodyRepository);
    }

    @Bean
    public UserPreferencesService userPreferencesService(IUserPreferencesRepository iUserPreferencesRepository){
        return new UserPreferencesService(iUserPreferencesRepository);
    }

    @Bean
    public RegistrationService registrationService(IUserRepository iUserRepository, BCryptPasswordEncoder passwordEncoder){
        return new RegistrationService(iUserRepository, passwordEncoder);
    }

    public ExerciseMachineService exerciseMachineService(IExerciseMachineRepository iExerciseMachineRepository, UploadFile uploadFile){
        return new ExerciseMachineService(iExerciseMachineRepository, uploadFile);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("GymWise API").version("1.0").description("Documentación de los servicios de GymWise"))
                .addSecurityItem(new SecurityRequirement().addList("BearerAuth")).components(new Components()
                .addSecuritySchemes("BearerAuth", new SecurityScheme().name("BearerAuth").type(SecurityScheme.Type.HTTP)
                .scheme("bearer").bearerFormat("JWT")));
    }

}
