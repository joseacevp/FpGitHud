/*
 * Ejercicio Realizado Para el Modulo Acceso a Datos
 * Curso Desarrollo de aplicaciones Multiplataforma
 * IES Juan Bosco
 */
package tema5db4o;

import Modelo.Jefe;
import Modelo.Secretario;
import Utilidades.CrearJefe;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.io.File;

/**
 *
 * @author Jose Antonio Acevedo Paredes
 */
public class Tema5DB4o {

    /** 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //La base de datos física es el fichero "BDJefes.db" almacenado en la
        //carpeta ficheros del proyecto creado
        //la base de datos se alojará el proyecto dentro  de la carpeta ficheros
        File fichero = new File("Ficheros/BDJefes.db");
        fichero.delete();//borra el fichero evitando duplicar datos

        ObjectContainer baseDatos = Db4oEmbedded.openFile(fichero.getAbsolutePath());

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
        baseDatos.store(CrearJefe.crear());//llama metod para crear nuevo jefe con menu
        
//La información que se trata de representar para los Jefes es el nombre ,
        //numero de años en la empresas , la edad y el nombre y edad de su secretario
        
        Jefe jefe = new Jefe();//devuelve los que tienen 3 años de antiguedad
        ObjectSet<Jefe> resultado = baseDatos.queryByExample(jefe);//da los datos de la consulta
        while (resultado.hasNext()) {
            System.out.println(resultado.next());

        }

        baseDatos.close();//cierrra la base de datos
    }
}
