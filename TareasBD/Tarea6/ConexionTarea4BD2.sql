--Actividad 1.
--Queremos crear los siguientes subprogramas:
--1.    Función que compruebe si existe un pedido con el número que se le pase. Devolverá verdadero o falso.
create or replace function HayPedido(v_numeroPedido pedidos.num%type)
return boolean
as
    v_resultado boolean:=true;
    v_num pedidos.num%type;
begin
    select num into v_num from pedidos
    where num=v_numeroPedido;
RETURN v_resultado;      
exception
    when no_data_found then
    v_resultado:=false;
RETURN v_resultado;    
end;
/
--llamada a funcion
declare 
    v_num pedidos.num%type:=&num;
    v_resultado boolean;
begin
    v_resultado:=haypedido(v_num);
        if v_resultado=true then
            dbms_output.put_line('true');
        else 
            dbms_output.put_line('false');
        end if;
end;
/

--2.    Función que devuelve todos los datos de un pedido a partir de su número (toda la fila de la tabla pedidos)
create or replace function DatosPedido(v_num_pedido pedidos.num%type)
    return pedidos%rowtype
        
    as
        v_pedidos pedidos%rowtype;
    begin
        SELECT * INTO v_pedidos
        FROM pedidos
        WHERE num = v_num_pedido ;
    return v_pedidos;
end;
/  
--llamada a funcion
declare 
    v_num pedidos.num%type:=&num;
    v_resultado  pedidos%rowtype;
begin
    v_resultado:=datospedido(v_num);
    --impresion por pantalla de los datos devueltos
        DBMS_OUTPUT.put_line('numero pedido '||v_resultado.NUM||
            ' fecha '||v_resultado.FECHA||
            ' gastos envio '||v_resultado.GASTOS_ENVIO||
            ' fecha prevista '||v_resultado.FECHA_PREVISTA ||
            ' total '||v_resultado.TOTAL||
            ' cliente '||v_resultado.CLIENTE
        );
end;
/

--3.  Procedimiento que devuelve los datos de un cliente a partir del  código de cliente
create or replace PROCEDURE datosCliente(v_codigo clientes.codigo%TYPE )
     as 
        v_clientes clientes%rowtype;
    BEGIN 
        SELECT * INTO v_clientes
        FROM clientes
        WHERE codigo = v_codigo ;
    --impresion por pantalla de los datos devueltos
        DBMS_OUTPUT.put_line('codigo cliente '||v_clientes.codigo||
            ' nombre '||v_clientes.nombre||
            ' apellidos '||v_clientes.apellidos||
            ' edad '|| v_clientes.edad
        );
END;
/
--llamada a funcion
declare 
    v_codigo clientes.codigo%TYPE := &codigo;
    begin
    datosCliente(v_codigo);
end;
/

--4.    Procedimiento que muestra un listado con las líneas de un pedido ( a partir de su número),  de la siguiente manera:
--             Nº Línea    NombreProducto       Precio    Cantidad     Importe
--             :::::::::  :::::::::::::::       :::::     :::::::      :::::::

create or replace procedure lineasPedido(v_num_pedido pedidos.num%type)
as

begin

end;
/

