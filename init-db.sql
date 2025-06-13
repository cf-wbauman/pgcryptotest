create table public.employees
(
    id    integer primary key not null default nextval('employees_id_seq'::regclass),
    name  text                not null,
    pesel bytea               not null
);

create sequence public.employee_id_seq
    increment by 50;
