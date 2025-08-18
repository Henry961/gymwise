package com.nigma.gymwise.GymWise.infrastucture.config;

import com.nigma.gymwise.GymWise.application.*;
import com.nigma.gymwise.GymWise.domain.port.*;
import com.nigma.gymwise.GymWise.infrastucture.adapter.IUserCrudRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

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

}
