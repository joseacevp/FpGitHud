--Actividad 1.
--Queremos crear los siguientes subprogramas:
--1.    Función que compruebe si existe un pedido con el número que se le pase. Devolverá verdadero o falso.
create or replace function hayPedido(v_numeroPedido pedidos.num%type)
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
        DBMS_OUTPUT.put_line('El numero de pedido no existe: ');
    RETURN v_resultado;
        when value_error then
        DBMS_OUTPUT.put_line('Error al indicar datos ');
        v_resultado:=false;
    RETURN v_resultado;
    when others then
        DBMS_OUTPUT.put_line('Error ');
        v_resultado:=false;
       
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
create or replace function datosPedido(v_num_pedido pedidos.num%type)
    return pedidos%rowtype
        
    as
        v_pedidos pedidos%rowtype;
    begin
        SELECT * INTO v_pedidos
        FROM pedidos
        WHERE num = v_num_pedido ;
    return v_pedidos;
    exception 
        when others then
        DBMS_OUTPUT.put_line('Error ');
end;
/
--llamada a funcion
declare 
    v_num pedidos.num%type:=&num;
    v_resultado  pedidos%rowtype;
begin
    if haypedido(v_num)=true then
    v_resultado:=datospedido(v_num);
    --impresion por pantalla de los datos devueltos
        DBMS_OUTPUT.put_line('numero pedido '||v_resultado.NUM||
            ' fecha '||v_resultado.FECHA||
            ' gastos envio '||v_resultado.GASTOS_ENVIO||
            ' fecha prevista '||v_resultado.FECHA_PREVISTA ||
            ' total '||v_resultado.TOTAL||
            ' cliente '||v_resultado.CLIENTE
        );
        end if ;
    exception 
        when others then
        DBMS_OUTPUT.put_line('Error ');
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
    exception 
      when no_data_found then 
        DBMS_OUTPUT.put_line('cliente no existe');
    when others then
        DBMS_OUTPUT.put_line('Error ');
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

create or replace procedure lineasPedido(v_num_pedido lineas.num_pedido%type)
    as
       cursor lineas_pedido_cursor is 
            select NUM ,
                PRODUCTO ,
                CANTIDAD ,
               (select precio from productos where codigo=lineas.producto and lineas.num_pedido=1)as precio,
                IMPORTE 
            from lineas
            where lineas.num_pedido=v_num_pedido;
    begin
         DBMS_OUTPUT.put_line(' Nº Línea NombreProducto Precio Cantidad Importe');
        for registro in lineas_pedido_cursor loop
            DBMS_OUTPUT.put_line('     '||registro.num||'         '||registro.producto||'      '||registro.precio||'      '||registro.cantidad||'        '||registro.importe);
        end loop;
    exception 
        when no_data_found then
            DBMS_OUTPUT.put_line('sin datos para esta consulta');
        when others then
            DBMS_OUTPUT.put_line('Error ');
end;
/
--llamada a procedimiento
declare 
    v_num_pedido lineas.num_pedido%type:=&numero;
begin
    if haypedido(v_num_pedido) is null then
     DBMS_OUTPUT.put_line('el pedido no existe');
    else   
     lineasPedido(v_num_pedido);
    end if;
end;
/

--5.    Procedimiento o bloque anónimo que a partir de un número de pedido, si existe, nos muestre todos los datos del pedido,
--del cliente y el listado de todas las líneas que tiene, utilizando los subprogramas anteriores.  
create or replace procedure datosPedidoCliente(v_num_pedido pedidos.num%type)
    as
        cursor c_pedido_cliente_lineas is
        select * from pedidos p,clientes c
        where p.num=v_num_pedido and p.cliente=c.codigo;
    begin
         DBMS_OUTPUT.put_line('num fecha     gastos envio   fecha_pre  total num_cli codigo_cli  nombre apellidos    edad');
         for registro in c_pedido_cliente_lineas loop
          DBMS_OUTPUT.put_line(registro.num||
          '   '||registro.fecha||
          '     '||registro.gastos_envio||
          '           '||registro.fecha_prevista||
          '    '||registro.total||
          '     '||registro.cliente||
          '        '||registro.codigo||
          '        '||registro.nombre||
          ' '||registro.apellidos||
          '     '||registro.edad
         );
        end loop;
    exception 
        when no_data_found then
            DBMS_OUTPUT.put_line('sin datos para esta consulta');
        when others then
            DBMS_OUTPUT.put_line('Error ');
end;
/
-- llamada a procedimiento
declare
    v_num_pedido pedidos.num%type:=&numero;
begin
    if haypedido(v_num_pedido) is null then
        DBMS_OUTPUT.put_line('el pedido no existe');
    else   
        datosPedidoCliente(v_num_pedido);
        lineaspedido(v_num_pedido);
    end if;
end;
/


--Actividad 2.
--Queremos controlar algunas restricciones mediante  triggers: (debes crear dos disparadores, uno para cada ejercicio):
--1.    Cada vez que se vaya a insertar o modificar una línea de un pedido debe de actualizarse correctamente el importe 
--de la misma (cantidad X precio del producto).


