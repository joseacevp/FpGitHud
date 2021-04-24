--prueba de los tipos miembroEscolar y profesor

declare 
    v_miembroEscolar miembroescolar;--instancia el objeto usando una referencia de su tipo.
    v_profesor profesor;
    v_profesor2 profesor;
    v_profe_curso ref profesor;
    v_curso curso;
    v_profesor3 profesor;
begin
    --se crea el objeto
    v_miembroEscolar := new miembroescolar(1,'21121','jose','acevec pareesee','H','12/02/02');
    --devuelve los datos del objeto
    dbms_output.put_line(v_miembroescolar.codigo);
    v_profesor := new profesor(1,'21121','jose','acevec pareesee','H','12/02/02','espe',2);
    dbms_output.put_line(v_profesor.especialidad);
    --codigo integer , nombre varchar2, primer_apellido varchar2, segundo_apellido varchar2, especialidad varchar2
    v_profesor2 := new profesor(1,'pepito','delos', 'palotes', 'pringao');
    dbms_output.put_line(v_profesor2.apellidos);
    dbms_output.put_line(v_profesor2.getNombreCompleto);
    
    --select ref(p) into v_profe_curso from profesorados p where codigo=1;
    
    --v_curso := new curso(1,'curso primero',v_profe_curso ,200,'12/12/12','14/12/13',100);
    
select deref(v_profe_curso) into v_profesor3 from dual;
    dbms_output.put_line(v_profesor3.nombre);
end;
/
---------------------------------------------------
insert into profesorados values( 2,'51083099F','MARIA LUISA',' FABRE BERDUN','F','31/03/1975','TECNOLOGIA',4
);

insert into profesorados values(profesor(3,'JAVIER','JIMENEZ', 'HERNANDO', 'LENGUA'));

-------------------------------------------------------
--7. Crea un tipo colección VARRAY llamada "ListaCursos" en la que se puedan almacenar hasta 10 objetos "Cursos".














