package com.nigma.gymwise.GymWise.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    private Integer id;
    private Integer userId;
    private Integer rating;
    private String comments;
    private java.time.LocalDateTime feedbackDate;
}
