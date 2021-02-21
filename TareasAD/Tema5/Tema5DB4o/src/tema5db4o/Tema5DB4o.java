/*
 * Ejercicio Realizado Para el Modulo Acceso a Datos
 * Curso Desarrollo de aplicaciones Multiplataforma
 * IES Juan Bosco
 */
package tema5db4o;

import Modelo.Jefe;
import Utilidades.BorraDatosDB4o;
import Utilidades.CambioSecretario;
import Utilidades.ConectaDB4o;
import Utilidades.ConsultaDB4o;
import Utilidades.ConsultaTodoContenidoDB4o;
import Utilidades.IngresaDatosInicialesEnDB4o;
import Utilidades.CrearJefe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose Antonio Acevedo Paredes
 */
public class Tema5DB4o {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Menu Principal:\n\n");
            System.out.println("1.Rellenar la Base de Datos DB4o con datos por defecto.");
            System.out.println("2.Añadir nuevos Jefes.");
            System.out.println("3.Visualizar en pantalla  los jefes que tengan."
                    + " más de una determinada edad años y tengan una experiencia\n"
                    + " en la empresa. ");
            System.out.println("4.Cambiar de secretario de un jefe indicado. ");
            System.out.println("5.Borrar los jefes que llevan más de  tantos  años\n"
                    + " en la empresa.");
            System.out.println("6.Visualizar los datos de todos los jefes que, incluidos\n "
                    + " los datos de su secretario.");
            System.out.println("0.Salir");

            int i = Integer.parseInt(br.readLine());
            while (i != 0) {
                switch (i) {
                    case 1:
                        IngresaDatosInicialesEnDB4o.crearDB(ConectaDB4o.conecta());
                        i = 0;
                        break;
                    case 2:
                        CrearJefe.crear(ConectaDB4o.conecta());
                        i = 0;
                        break;
                    case 3:
                        ConsultaDB4o.consultar(ConectaDB4o.conecta());
                        i = 0;
                        break;
                    case 4:
                        Jefe jefeAcambiar = new Jefe();
                        System.out.println("Nombre de Jefe:");
                        jefeAcambiar.setNombre(br.readLine());
                        CambioSecretario.cambiar(ConectaDB4o.conecta(),jefeAcambiar);
                        i = 0;
                        break;
                    case 5:
                        Jefe jefeAborrar = new Jefe();
                        System.out.println("Antiguedad en la empresa de los Jefes"
                                + " a borrar o 0 pra borrar todos los Jefes:");
                        jefeAborrar.setAntiguedad(Integer.parseInt(br.readLine()));
                        BorraDatosDB4o.borrar(ConectaDB4o.conecta(), jefeAborrar);
                        i = 0;
                        break;
                    case 6:
                        Jefe jefe = new Jefe();
                        ConsultaTodoContenidoDB4o.consultaTodo(jefe, ConectaDB4o.conecta());
                        i = 0;
                        break;

                }
            }

            //baseDatos.close();//cierrra la base de datos
        } catch (IOException ex) {
            System.out.println("FALLO " + ex);
        }
    }
}
