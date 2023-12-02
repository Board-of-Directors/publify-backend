create table issue
(
    id           bigserial primary key,
    name         varchar,
    description  varchar,
    number       int,
    release_date date,
    cover        varchar,
    journal_id   bigint references journal (id)
)