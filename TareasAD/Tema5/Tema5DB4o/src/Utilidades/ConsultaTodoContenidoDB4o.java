/*
 * Ejercicio Realizado Para el Modulo Acceso a Datos
 * Curso Desarrollo de aplicaciones Multiplataforma
 * IES Juan Bosco
 */
package Utilidades;

import Modelo.Jefe;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

/**
 *
 * @author Jose Antonio Acevedo Paredes
 */
public class ConsultaTodoContenidoDB4o {

    public static void consultaTodo(Object objeto, ObjectContainer baseDatos) {

        ObjectSet<Object> resultado = baseDatos.queryByExample(objeto);//da los datos de la consulta
        while (resultado.hasNext()) {
            System.out.println(resultado.next());

        }
        //cerrar conexion tras usarla
        baseDatos.close();//cierrra la base de datos

    }
}
