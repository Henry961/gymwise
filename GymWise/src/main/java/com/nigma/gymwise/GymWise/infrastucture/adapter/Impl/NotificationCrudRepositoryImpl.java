package com.nigma.gymwise.GymWise.infrastucture.adapter;

import com.nigma.gymwise.GymWise.domain.model.Notification;
import com.nigma.gymwise.GymWise.domain.port.INotificationRepository;
import com.nigma.gymwise.GymWise.infrastucture.entity.NotificationEntity;
import com.nigma.gymwise.GymWise.infrastucture.mapper.INotificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class NotificationCrudRepositoryImpl implements INotificationRepository {
    @Autowired
    private INotificationCrudRepository crudRepository;

    @Autowired
    private INotificationMapper mapper;

    @Override
    public Notification save(Notification notification) {
        NotificationEntity entity = mapper.toNotificationEntity(notification);
        NotificationEntity saved = crudRepository.save(entity);
        return mapper.toNotification(saved);
    }

    @Override
    public Optional<Notification> findById(Integer id) {
        return crudRepository.findById(id).map(mapper::toNotification);
    }

    @Override
    public List<Notification> findAll() {
        return StreamSupport
                .stream(crudRepository.findAll().spliterator(), false)
                .map(mapper::toNotification)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        crudRepository.deleteById(id);
    }
}
