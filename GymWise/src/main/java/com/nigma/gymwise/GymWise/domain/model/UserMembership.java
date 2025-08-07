package com.nigma.gymwise.GymWise.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMembership {
    private Integer id;
    private Integer userId;
    private Integer trainerId;
    private Integer typeMembershipId;
    private java.time.LocalDate expirationDate;
    private Boolean active;
}
