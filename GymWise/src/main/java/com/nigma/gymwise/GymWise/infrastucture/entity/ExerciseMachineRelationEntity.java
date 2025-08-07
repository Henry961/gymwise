package com.nigma.gymwise.GymWise.infrastucture.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exercise_machine_relation")
public class ExerciseMachineRelationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id_exc_mch")
    private Integer id;
    @Column(name = "fk_id_exc")
    private Integer exerciseId;
    @Column(name = "fk_id_mch")
    private Integer machineId;
}
