create table journal
(
    id              bigserial primary key ,
    title           varchar,
    description     varchar,
    organization_id bigint
);


create table journal_editors
(
    id          bigserial primary key ,
    journal_id  bigint references journal (id),
    employee_id bigint references employee (id)
);