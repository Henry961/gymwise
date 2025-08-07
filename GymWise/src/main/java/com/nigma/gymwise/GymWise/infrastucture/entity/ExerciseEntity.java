package com.nigma.gymwise.GymWise.infrastucture.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exercise")
public class ExerciseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id_exercise")
    private Integer id;
    @Column(name = "exercise_name")
    private String name;
    @Column(name = "exercise_description")
    private String description;
    @Column(name = "url_img")
    private String urlImg;
    @Column(name = "url_video")
    private String urlVideo;
}
