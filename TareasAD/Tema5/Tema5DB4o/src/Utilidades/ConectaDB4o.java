/*
 * Ejercicio Realizado Para el Modulo Acceso a Datos
 * Curso Desarrollo de aplicaciones Multiplataforma
 * IES Juan Bosco
 */
package Utilidades;

import Modelo.Jefe;
import Modelo.Secretario;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.io.File;

/**
 *
 * @author Jose Antonio Acevedo Paredes
 */
public class ConectaDB4o {

    public static ObjectContainer conecta() {

        File fichero = new File("Ficheros/BDJefes.db");
        //fichero.delete();//borra el fichero evitando duplicar datos
        ObjectContainer baseDatos = Db4oEmbedded.openFile(fichero.getAbsolutePath());

        System.out.println("DB4O CONECTADA-------------");


//La información que se trata de representar para los Jefes es el nombre ,
        //numero de años en la empresas , la edad y el nombre y edad de su secretario
        
        return baseDatos;

    }
}
