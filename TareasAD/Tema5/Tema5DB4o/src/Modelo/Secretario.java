/*
 * Ejercicio Realizado Para el Modulo Acceso a Datos
 * Curso Desarrollo de aplicaciones Multiplataforma
 * IES Juan Bosco
 */
package Modelo;

/**
 *
 * @author Jose Antonio Acevedo Paredes
 */
public class Secretario {

    private String nombre;
    private int edad;

    public Secretario() {
    }

    public Secretario(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Secretario{" + "nombre=" + nombre + ", edad=" + edad + '}';
    }
    
    
}
