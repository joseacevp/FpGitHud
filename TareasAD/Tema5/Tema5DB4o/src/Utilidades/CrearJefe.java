/*
 * Ejercicio Realizado Para el Modulo Acceso a Datos
 * Curso Desarrollo de aplicaciones Multiplataforma
 * IES Juan Bosco
 */
package Utilidades;

import Modelo.Jefe;
import Modelo.Secretario;
import com.db4o.ObjectContainer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Jose Antonio Acevedo Paredes
 */
public class CrearJefe {

    public static Jefe crear(ObjectContainer baseDatos) {
        Jefe nuevoJefe = new Jefe();
        try {

            Secretario secretario = new Secretario();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//instanciacion de br para leer por teclado

            System.out.println("Menu crear Jefe:\n");
            
            System.out.println("Indicar Nombre:\n");
            nuevoJefe.setNombre(br.readLine());
            System.out.println("Indicar Edad:\n");
            nuevoJefe.setEdad(Integer.parseInt(br.readLine()));
            System.out.println("Indicar Antiguedad:\n");
            nuevoJefe.setAntiguedad(Integer.parseInt(br.readLine()));
            System.out.println("Indicar Nombre Secretario/a:\n");
            secretario.setNombre(br.readLine());
            System.out.println("Indicar Edad Secretario/a:\n");
            secretario.setEdad(Integer.parseInt(br.readLine()));
            nuevoJefe.setSecretario(secretario);
            
            //añadir jefe a bd
            baseDatos.store(nuevoJefe);
            baseDatos.close();
            
        } catch (IOException ex) {
            System.out.println("Fallo indicando datos.");
        }
        return nuevoJefe;

    }

}
