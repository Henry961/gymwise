package com.nigma.gymwise.GymWise.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {
    private Integer id;
    private String name;
    private String description;
    private String urlImg;
    private String urlVideo;
}
