create or replace type alumno as object(
        DNI varchar2(9),
        Nombre varchar2(30),
        Apellidos varchar2(50),
        Direccion varchar2(50),
        FechaNac date
);
--
drop table alumnos
--
create table alumnos of alumno(
primary key (dni)
);
--
insert into alumnos values('21212121s','jose','ace','calle uno','12/12/12');
--
select * from alumnos
