create table movie
(
   id integer not null,
   uuid varchar(36) not null,
   title varchar(255) not null,
   release_date date not null,
   primary key(id)
);