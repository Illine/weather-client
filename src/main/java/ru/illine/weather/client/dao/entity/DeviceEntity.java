package ru.illine.weather.client.dao.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = {"id", "uuid"})
@Entity
@Table(
        name = "devices",
        indexes = @Index(name = "devices_uuid_uindex", columnList = "uuid", unique = true)
)
public class DeviceEntity extends AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deviceSeqGenerator")
    @SequenceGenerator(name = "deviceSeqGenerator", sequenceName = "devices_seq", allocationSize = 1)
    private Long id;

    @Column(name = "uuid", nullable = false)
    private String uuid;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "user_id")
    private UserEntity user;

}