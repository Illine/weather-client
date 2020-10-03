--liquibase formatted sql

--changeset eekovtun:1.0.0/ddl/users_seq
--rollback drop sequence client.users_seq;
create sequence client.users_seq;

--changeset eekovtun:1.0.0/ddl/users
--rollback drop table client.users;
create table client.users
(
    id      bigint       default nextval('client.users_seq'::regclass) not null
        constraint users_pk primary key,
    created timestamp(0) default now(),
    updated timestamp(0) default now(),
    active  boolean      default true
);

comment on table client.users is 'A table stores weather clients';
comment on column client.users.created is 'A created date';
comment on column client.users.updated is 'A updated date';
comment on column client.users.active is 'A soft deleted flag: true - active, false - deleted';