--liquibase formatted sql

--changeset eekovtun:1.0.0/ddl/devices_seq
--rollback drop sequence client.devices_seq;
create sequence client.devices_seq;

--changeset eekovtun:1.0.0/ddl/devices
--rollback drop table client.devices;
create table client.devices
(
    id      bigint       default nextval('client.devices_seq'::regclass) not null
        constraint devices_pk primary key,
    user_id bigint
        constraint user_id_fk
            references client.users (id)                                 not null,
    uuid    varchar(255)                                                 not null,
    created timestamp(0) default now(),
    updated timestamp(0) default now(),
    active  boolean      default true
);

comment on table client.devices is 'A table stores devices of clients';
comment on column client.devices.user_id is 'Foreign key from users.id';
comment on column client.devices.uuid is 'A uniq identifier of a device';
comment on column client.devices.created is 'A created date';
comment on column client.devices.updated is 'A updated date';
comment on column client.devices.active is 'A soft deleted flag: true - active, false - deleted';

create unique index devices_uuid_uindex
    on client.devices (uuid);