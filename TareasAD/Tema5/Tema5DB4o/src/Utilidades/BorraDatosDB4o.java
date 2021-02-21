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
public class BorraDatosDB4o {

    public static void borrar(ObjectContainer baseDatos, Jefe jefeAborrar) {
        ObjectSet<Jefe> resultado = baseDatos.queryByExample(jefeAborrar);//da los datos de la consulta

        while (resultado.hasNext()) {
            Jefe jefe=new Jefe();
                    
            System.out.println("Jefe Borrado.");
            jefe = resultado.next();
            System.out.println(jefe);
            baseDatos.delete(jefe);

        }
        baseDatos.commit();
        baseDatos.close();
              
    }
}
