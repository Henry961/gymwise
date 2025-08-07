package com.nigma.gymwise.GymWise.application;

import com.nigma.gymwise.GymWise.domain.model.Notification;
import com.nigma.gymwise.GymWise.domain.port.INotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {
    private final INotificationRepository repository;

    public NotificationService(INotificationRepository repository) {
        this.repository = repository;
    }

    public Notification save(Notification notification) {
        return repository.save(notification);
    }

    public Optional<Notification> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Notification> findAll() {
        return repository.findAll();
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
