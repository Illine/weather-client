package ru.illine.weather.client.dao.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = "id")
@Entity
@Table(
        name = "users"
)
public class UserEntity extends AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeqGenerator")
    @SequenceGenerator(name = "userSeqGenerator", sequenceName = "users_seq", allocationSize = 1)
    private Long id;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "user", orphanRemoval = true)
    private Set<DeviceEntity> devices = new HashSet<>();

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "user", orphanRemoval = true)
    private Set<LocationEntity> locations = new HashSet<>();
}