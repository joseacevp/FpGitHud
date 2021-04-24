--------------------------------------------------------
-- Archivo creado  - miércoles-abril-14-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Type ALUMNO
--------------------------------------------------------

  CREATE OR REPLACE TYPE "BD07"."ALUMNO" under miembroEscolar(
    cursoAlumno Curso

);

/
--------------------------------------------------------
--  DDL for Type CURSO
--------------------------------------------------------

  CREATE OR REPLACE TYPE "BD07"."CURSO" as object(
codigo INTEGER,
nombre VARCHAR2(20),
refProfe REF Profesor,
max_Alumn INTEGER,
fecha_Inic DATE,
fecha_Fin DATE,
num_Horas INTEGER,
map member function ordenarCursos return varchar2--Método MAP "ordenarCursos" para el tipo "Cursos". Este método
--debe retornar el nombre completo del profesor al que hace referencia cada curso. Para obtener el nombre debes
--utilizar el método getNombreCompleto que se ha creado anteriormente.
    
);
/
CREATE OR REPLACE TYPE BODY "BD07"."CURSO" AS

    map member function ordenarCursos return varchar2 is
        v_profe_curso ref profesor;
        v_curso curso;
        v_profesor profesor;
    BEGIN
        select ref(p) into v_profe_curso from profesorados p where codigo=v_profesor.codigo;
        --v_curso := new curso(1,'curso primero',v_profe_curso ,200,'12/12/12','14/12/13',100);
        select deref(v_profe_curso) into v_profesor from dual;
        dbms_output.put_line(v_profesor.getNombreCompleto);
    RETURN v_profesor.getNombreCompleto();
    END ordenarCursos;

END;

/
--------------------------------------------------------
--  DDL for Type MIEMBROESCOLAR
--------------------------------------------------------

  CREATE OR REPLACE TYPE "BD07"."MIEMBROESCOLAR" as object(
codigo INTEGER,
dni VARCHAR2(10),
nombre VARCHAR2(30),
apellidos VARCHAR2(30),
sexo VARCHAR2(1),
fecha_nac DATE
)not final;

/
--------------------------------------------------------
--  DDL for Type PROFESOR
--------------------------------------------------------

  CREATE OR REPLACE TYPE "BD07"."PROFESOR" under miembroescolar(--hereda de miembroEscolar
especialidad VARCHAR2(20),
antiguedad INTEGER,
-- definicion el Método constructor para el tipo de objetos "Profesor", en el que se indiquen
--como parámetros el código, nombre, primer apellido, segundo apellido y especialidad.
--Este método debe asignar al atributo "apellidos" los datos de primer apellido y segundo 
--apellido que se han pasado como parámetros, uniéndolos con un espacio entre ellos.
constructor function Profesor (codigo integer , nombre varchar2, primer_apellido varchar2,
segundo_apellido varchar2, especialidad varchar2)
--devuelve los parametros del objeto asignado los parametros pasados en el constructor
return self as result,
member function getNombreCompleto return varchar2--definicion delMétodo "getNombreCompleto" para el tipo de objetos "Profesor" 
--que permita obtener su nombre completo con el formato "apellidos nombre". 

);
/
CREATE OR REPLACE TYPE BODY "BD07"."PROFESOR" AS
    constructor function Profesor (codigo integer , nombre varchar2, primer_apellido varchar2, segundo_apellido varchar2, especialidad varchar2)
    --devuelve los parametros del objeto asignado los parametros pasados en el constructor
    return self as result
    is
    BEGIN
        --parte de declaracion del metodo constructor
        --asignamos cada parametro del constructor a nuestro objeto con self
        self.codigo :=codigo;
        self.nombre :=nombre;
        self.apellidos :=  primer_apellido ||' ' || segundo_apellido;--concatenamos los apellidos para formar el parametro apellidos
        self.especialidad := especialidad;
    return ;--devuelve los parametros asignados al objeto atraves del constructor
    END ;--fin d constructor creado
    member function getNombreCompleto return varchar2--declaracion de Método "getNombreCompleto" para el tipo de objetos 
        --"Profesor" que permita obtener su nombre completo con el formato "apellidos nombre".
    is
        v_nombreCompleto varchar2(60);--declaracion de variable que recivira el resutado a devolver 
    begin
        v_nombreCompleto:= self.apellidos||' '||self.nombre;
    return v_nombreCompleto;
    end getNombreCompleto;
END;

/
--------------------------------------------------------
--  DDL for Table PROFESORADOS
--------------------------------------------------------

  CREATE TABLE "BD07"."PROFESORADOS" OF "BD07"."PROFESOR" 
 OIDINDEX  ( PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ) 
 PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into BD07.PROFESORADOS
SET DEFINE OFF;
Insert into BD07.PROFESORADOS (CODIGO,DNI,NOMBRE,APELLIDOS,SEXO,FECHA_NAC,ESPECIALIDAD,ANTIGUEDAD) values ('3',null,'JAVIER','JIMENEZ HERNANDO',null,null,'LENGUA',null);
Insert into BD07.PROFESORADOS (CODIGO,DNI,NOMBRE,APELLIDOS,SEXO,FECHA_NAC,ESPECIALIDAD,ANTIGUEDAD) values ('2','51083099F','MARIA LUISA',' FABRE BERDUN','F',to_date('31/03/75','DD/MM/RR'),'TECNOLOGIA','4');
--------------------------------------------------------
--  DDL for Index SYS_C0013122
--------------------------------------------------------

  CREATE UNIQUE INDEX "BD07"."SYS_C0013122" ON "BD07"."PROFESORADOS" ("CODIGO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0013123
--------------------------------------------------------

  CREATE UNIQUE INDEX "BD07"."SYS_C0013123" ON "BD07"."PROFESORADOS" ("SYS_NC_OID$") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table PROFESORADOS
--------------------------------------------------------

  ALTER TABLE "BD07"."PROFESORADOS" ADD PRIMARY KEY ("CODIGO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "BD07"."PROFESORADOS" ADD UNIQUE ("SYS_NC_OID$")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
