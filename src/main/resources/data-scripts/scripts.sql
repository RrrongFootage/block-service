create table place
(
    id            serial           not null
        constraint place_pkey
            primary key,
    archived_date timestamp,
    created_date  timestamp        not null,
    label         varchar(255)     not null,
    latitude      double precision not null,
    longitude     double precision not null,
    updated_date  timestamp        not null
);

alter table place
    owner to postgres;

create unique index place_label_uindex
    on place (label);

create unique index place_latitude_uindex
    on place (latitude);

create unique index place_longitude_uindex
    on place (longitude);

create table schedule
(
    id            serial       not null
        constraint schedule_pkey
            primary key,
    archived_date timestamp,
    created_date  timestamp    not null,
    key           varchar(255) not null
);

alter table schedule
    owner to postgres;

create unique index schedule_key_uindex
    on schedule (key);

create table serviceblock
(
    id            serial       not null
        constraint serviceblock_pkey
            primary key,
    archived_date timestamp,
    created_date  timestamp    not null,
    end_date      timestamp    not null,
    key           varchar(255) not null,
    start_date    timestamp    not null,
    updated_date  timestamp    not null,
    place_id      integer      not null
        constraint fk12goim8ys4ium40h6eb1dg75m
            references place,
    schedule_id   integer
        constraint fkjcodf25s363d9bmfdq0i5ai1y
            references schedule
);

alter table serviceblock
    owner to postgres;

create unique index serviceblock_key_uindex
    on serviceblock (key);

