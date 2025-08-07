package com.nigma.gymwise.GymWise.infrastucture.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "membership_type")
public class MembershipTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id_mbs_type")
    private Integer id;
    @Column(name = "abbreviation")
    private String abbreviation;
    @Column(name = "name_membership")
    private String nameMembership;
}
