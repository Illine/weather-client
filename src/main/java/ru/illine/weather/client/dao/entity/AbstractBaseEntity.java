package ru.illine.weather.client.dao.entity;

import lombok.Getter;
import lombok.Setter;
import ru.illine.weather.client.model.base.ActiveStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractBaseEntity {

    @Column(name = "created", updatable = false)
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    @Column(name = "active", nullable = false)
    private ActiveStatus active;

    @PrePersist
    protected void onCreate() {
        var current = LocalDateTime.now();
        created = current;
        modified = current;
        active = ActiveStatus.ENABLED;
    }

    @PreUpdate
    protected void onUpdate() {
        modified = LocalDateTime.now();
    }

    @PreRemove
    protected void onDelete() {
        modified = LocalDateTime.now();
        active = ActiveStatus.DISABLED;
    }
}