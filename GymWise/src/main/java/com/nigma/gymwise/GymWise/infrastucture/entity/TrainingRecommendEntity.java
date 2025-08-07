package com.nigma.gymwise.GymWise.infrastucture.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "training_recommend")
public class TrainingRecommendEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id_hist_tr")
    private Integer id;
    @Column(name = "fk_id_usr")
    private Integer userId;
    @Column(name = "fk_id_exc_mch")
    private Integer exerciseMachineRelationId;
    @Column(name = "reps")
    private Integer reps;
    @Column(name = "serie")
    private Integer serie;
    @Column(name = "rest_time")
    private Integer restTime;
    @Column(name = "start_date")
    private java.time.LocalDateTime startDate;
    @Column(name = "end_date")
    private java.time.LocalDateTime endDate;
}
