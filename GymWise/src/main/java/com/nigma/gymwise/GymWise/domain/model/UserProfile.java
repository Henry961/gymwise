package com.nigma.gymwise.GymWise.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {

    private Integer idUser;

    private Integer idDocumentType;

    private String nDocument;

    private String nameUser;

    private String lastName;

    private LocalDate birthdate;

    private String email;

    private String phoneNumber;

    private String passwordUser;

    private Integer idRol;

}
