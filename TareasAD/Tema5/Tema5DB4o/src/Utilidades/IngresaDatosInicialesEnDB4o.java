/*
 * Ejercicio Realizado Para el Modulo Acceso a Datos
 * Curso Desarrollo de aplicaciones Multiplataforma
 * IES Juan Bosco
 */

package Utilidades;

import Modelo.Jefe;
import Modelo.Secretario;
import com.db4o.ObjectContainer;
import java.io.File;

/**
 *
 * @author Jose Antonio Acevedo Paredes
 */
public class IngresaDatosInicialesEnDB4o {

    public static void crearDB(ObjectContainer baseDatos){
        
        
        
    //almacena los datos de los jefes con sus secretarios en la base de datos
        baseDatos.store(new Jefe("Nieves", 3, 45, new Secretario("Iván", 33)));
        baseDatos.store(new Jefe("Jesús", 10, 50, new Secretario("Noelia", 31)));
        baseDatos.store(new Jefe("Dolores", 15, 63, new Secretario("Sergio", 47)));
        baseDatos.store(new Jefe("Vicki", 3, 45, null));  //no tiene secretario
        baseDatos.store(new Jefe("Fátima", 25, 63, new Secretario("Lidia", 57)));
        baseDatos.store(new Jefe("Juan Luís", 13, 25, null));  //no tiene secretario
        baseDatos.store(new Jefe("Elena", 10, 42, new Secretario("David", 19)));
        baseDatos.store(new Jefe("Miguel", 20, 45, new Secretario("Paula", 23)));
        baseDatos.store(new Jefe("Jesús", 9, 44, new Secretario("Rubén", 32)));
        
        System.out.println("DB4o creada-----------------");
        /*Jefe jefe = new Jefe();//devuelve todos los jefes
        ObjectSet<Jefe> resultado = baseDatos.queryByExample(jefe);//da los datos de la consulta
        while (resultado.hasNext()) {
        System.out.println(resultado.next());
        
        }*/
        //cerrar conexion tras usarla
        baseDatos.close();//cierrra la base de datos*/
    
    }
}
