package com.nigma.gymwise.GymWise.infrastucture.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_membership")
public class UserMembershipEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id_mbs")
    private Integer id;
    @Column(name = "fk_id_user")
    private Integer userId;
    @Column(name = "fk_id_trainer")
    private Integer trainerId;
    @Column(name = "fk_id_type_membership")
    private Integer typeMembershipId;
    @Column(name = "expiration_date")
    private java.time.LocalDate expirationDate;
    @Column(name = "active")
    private Boolean active;
}
