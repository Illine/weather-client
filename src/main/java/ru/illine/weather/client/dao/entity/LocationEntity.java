package ru.illine.weather.client.dao.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = {"id", "name", "user"})
@Entity
@Table(
        name = "locations",
        indexes = @Index(name = "locations_name_user_id_uindex", columnList = "user_id,name", unique = true)
)
public class LocationEntity extends AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locationSeqGenerator")
    @SequenceGenerator(name = "locationSeqGenerator", sequenceName = "locations_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "user_id")
    private UserEntity user;

}