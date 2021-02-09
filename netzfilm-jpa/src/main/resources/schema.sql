create table customer
(
    id        integer      not null,
    uuid      varchar(36)  not null,
    name      varchar(255) not null,
    last_name varchar(255) not null,
    birthdate date         not null,
    primary key (id)
);