create table article
(
    id          bigserial primary key,
    name        varchar,
    description varchar,
    issue_id    bigint references issue (id)
)