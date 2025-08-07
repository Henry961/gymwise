package com.nigma.gymwise.GymWise.domain.port;

import com.nigma.gymwise.GymWise.domain.model.Notification;
import java.util.List;
import java.util.Optional;

public interface INotificationRepository {
    Notification save(Notification notification);
    Optional<Notification> findById(Integer id);
    List<Notification> findAll();
    void deleteById(Integer id);
}
