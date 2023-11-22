create table employee(
    id bigserial primary key ,
    email varchar unique,
    password varchar,
    name varchar,
    employee_role varchar,
    organization_id bigint references organization(id)
)