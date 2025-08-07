package com.nigma.gymwise.GymWise.infrastucture.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "user_profile")
@Data
@NoArgsConstructor
public class UserProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id_user")
    private Integer idUser;

    @Column(name = "fk_id_document_type")
    private Integer idDocumentType;

    @Column(name = "n_document")
    private String nDocument;

    @Column(name = "name_user")
    private String nameUser;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "password_user")
    private String passwordUser;

    @Column(name = "fk_id_rol")
    private Integer idRol;

}
