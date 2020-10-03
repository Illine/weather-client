--liquibase formatted sql

--changeset eekovtun:1.0.0/ddl/locations_seq
--rollback drop sequence client.locations_seq;
create sequence client.locations_seq;

--changeset eekovtun:1.0.0/ddl/locations
--rollback drop table client.locations;
create table client.locations
(
    id        bigint       default nextval('client.locations_seq'::regclass) not null
        constraint locations_pk primary key,
    user_id   bigint
        constraint user_id_fk
            references client.users (id)                                     not null,
    name      varchar(255)                                                   not null,
    longitude real                                                           not null,
    latitude  real                                                           not null,
    created   timestamp(0) default now(),
    updated   timestamp(0) default now(),
    active    boolean      default true
);

comment on table client.locations is 'A table stores weather clients';
comment on column client.locations.user_id is 'Foreign key from users.id';
comment on column client.locations.name is 'Coordinate name';
comment on column client.locations.longitude is 'Geographic longitude';
comment on column client.locations.latitude is 'Geographic latitude';
comment on column client.locations.created is 'A created date';
comment on column client.locations.updated is 'A updated date';
comment on column client.locations.active is 'A soft deleted flag: true - active, false - deleted';

create unique index locations_name_user_id_uindex
    on client.locations (user_id, name);