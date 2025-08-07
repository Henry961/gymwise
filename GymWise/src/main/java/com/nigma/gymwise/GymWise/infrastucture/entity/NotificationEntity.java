package com.nigma.gymwise.GymWise.infrastucture.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notification")
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id_notification")
    private Integer id;
    @Column(name = "fk_id_user")
    private Integer userId;
    @Column(name = "notification_message")
    private String notificationMessage;
    @Column(name = "notification_status")
    private String notificationStatus;
    @Column(name = "date_sent")
    private java.time.LocalDateTime dateSent;
}
