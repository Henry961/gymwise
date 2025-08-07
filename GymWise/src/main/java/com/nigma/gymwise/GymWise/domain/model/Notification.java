package com.nigma.gymwise.GymWise.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    private Integer id;
    private Integer userId;
    private String notificationMessage;
    private String notificationStatus;
    private java.time.LocalDateTime dateSent;
}
