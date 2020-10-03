package ru.illine.weather.client.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.illine.weather.client.dao.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}