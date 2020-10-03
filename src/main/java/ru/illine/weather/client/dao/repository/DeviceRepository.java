package ru.illine.weather.client.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.illine.weather.client.dao.entity.DeviceEntity;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity, Long> {
}