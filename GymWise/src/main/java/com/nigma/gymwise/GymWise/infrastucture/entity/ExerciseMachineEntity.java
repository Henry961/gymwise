package com.nigma.gymwise.GymWise.infrastucture.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exercise_machine")
public class ExerciseMachineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id_mch")
    private Integer pkIdMch;

    @Column(name = "em_name")
    private String emName;

    @Column(name = "em_description")
    private String emDescription;

    @Column(name = "url_img")
    private String urlImg;
}
