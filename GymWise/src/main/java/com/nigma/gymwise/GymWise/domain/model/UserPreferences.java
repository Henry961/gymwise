package com.nigma.gymwise.GymWise.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPreferences {

    private Integer idUserPreferences;

    private Integer idUser;

    private String goal;

    private String dietaryRestrictions;

    private String limitations;

}
