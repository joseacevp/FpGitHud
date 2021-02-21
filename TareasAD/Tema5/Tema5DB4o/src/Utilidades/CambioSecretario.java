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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Jose Antonio Acevedo Paredes
 */
public class CambioSecretario {

    /*    3.	Cambiar de secretarioJefeNuevo de un jefe indicado. El nombre del jefe a
    modificar y los datos del nuevo secretarioJefeNuevo se indicarán por teclado.*/
    public static void cambiar(ObjectContainer baseDatos, Jefe jefeViejo) {

        //Secretario secretarioJefeNuevo = new Secretario();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Jefe jefeNuevo = new Jefe();
        try {
            
            ObjectSet<Jefe> resultado = baseDatos.queryByExample(jefeViejo);//da los datos de la consulta

            while (resultado.hasNext()) {
                System.out.println("Jefe encontrado.");
                //System.out.println(resultado.next());
                jefeNuevo = resultado.next();
                System.out.println(jefeNuevo);
                
            }
            Secretario secretarioJefeNuevo = new Secretario();
            System.out.println("Menu cambiar Secretario/a:\n");
            System.out.println("Indicar Nombre Secretatio/a:\n");
            secretarioJefeNuevo.setNombre(br.readLine());
            System.out.println("Indicar Edead Secretatio/a:\n");
            secretarioJefeNuevo.setEdad(Integer.parseInt(br.readLine()));
            //Consulta en la base de datos le jefe por el nombre y lo devuelve
            jefeNuevo.setSecretario(secretarioJefeNuevo);
            baseDatos.store(jefeNuevo);
            baseDatos.close();//cierrra la base de datos
            System.out.println(jefeNuevo);
           
        } catch (IOException ex) {
            System.out.println("Fallo indicando datos.");
        }

    }

}
