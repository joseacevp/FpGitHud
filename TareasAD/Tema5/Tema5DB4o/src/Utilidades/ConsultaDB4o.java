/*
 * Ejercicio Realizado Para el Modulo Acceso a Datos
 * Curso Desarrollo de aplicaciones Multiplataforma
 * IES Juan Bosco
 */
package Utilidades;

import Modelo.Jefe;
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

 /* 3.	Visualizar en pantalla  los jefes que tengan más de una
            determinada edad años y tengan una experiencia en la empresa. Ambos
            valores se solicitarán por teclado.
             */
public class ConsultaDB4o {

    public static void consultar(ObjectContainer baseDatos) {
        try {
            Jefe jefe = new Jefe();
            //Secretario secretario = new Secretario();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           
            System.out.println("Menu Consulta:\n");

            System.out.println("Indicar Edad de Jefe:\n");
            jefe.setEdad(Integer.parseInt(br.readLine()));
            System.out.println("Indicar Años de Experiencia:\n");
            jefe.setAntiguedad(Integer.parseInt(br.readLine()));

            Jefe jefeC = new Jefe(null, jefe.getEdad(), jefe.getAntiguedad(), null);

            ObjectSet<Jefe> resultado = baseDatos.queryByExample(jefeC);//da los datos de la consulta
            while (resultado.hasNext()) {
                System.out.println(resultado.next());

            }

            baseDatos.close();//cierrra la base de datos

        } catch (IOException ex) {
            System.out.println("Fallo indicando datos");

        }
    }
}
