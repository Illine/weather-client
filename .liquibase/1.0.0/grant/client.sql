--liquibase formatted sql

--changeset eekovtun:1.0.0/grants/client context:!unit-tests
--rollback revoke all on schema client from client;
grant usage on schema client to client;
grant execute on all functions in schema client to client;
grant select, insert, update, delete on all tables in schema client to client;
grant usage, select on all sequences in schema client to client;