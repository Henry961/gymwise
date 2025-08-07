package com.nigma.gymwise.GymWise.infrastucture.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_preferences")
@Data
@NoArgsConstructor
public class UserPreferencesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id_user_preferences")
    private Integer idUserPreferences;

    @Column(name = "fk_id_user")
    private Integer idUser;

    @Column(name = "goal")
    private String goal;

    @Column(name = "dietary_restrictions")
    private String dietaryRestrictions;

    @Column(name = "limitations")
    private String limitations;

}
