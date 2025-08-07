package com.nigma.gymwise.GymWise.infrastucture.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "feedback")
public class FeedbackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id_feedback")
    private Integer id;
    @Column(name = "fk_id_user")
    private Integer userId;
    @Column(name = "rating")
    private Integer rating;
    @Column(name = "comments")
    private String comments;
    @Column(name = "feedback_date")
    private java.time.LocalDateTime feedbackDate;
}
