create table Todo
(
    id           integer primary key generated always as identity,
    title        varchar(255) not null,
    creationDate timestamp    not null,
    doneDate     timestamp    null
);
create index idx_Todo_creationDate on Todo (creationDate);
