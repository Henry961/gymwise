package com.nigma.gymwise.GymWise.infrastucture.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_record")
public class UserRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id_record")
    private Integer id;
    @Column(name = "fk_id_user")
    private Integer userId;
    @Column(name = "date_record")
    private java.time.LocalDate dateRecord;
}
