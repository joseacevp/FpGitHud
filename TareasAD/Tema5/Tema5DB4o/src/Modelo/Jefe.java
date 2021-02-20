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
public class Jefe {

    private String nombre;
    private int edad;
    private int antiguedad;
    private Secretario secretario;

    public Jefe() {
    }

    public Jefe(String nombre, int edad, int antiguedad, Secretario secretario) {
        this.nombre = nombre;
        this.edad = edad;
        this.antiguedad = antiguedad;
        this.secretario = secretario;
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

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Secretario getSecretario() {
        return secretario;
    }

    public void setSecretario(Secretario secretario) {
        this.secretario = secretario;
    }

    @Override
    public String toString() {
        return "Jefe{" + "nombre=" + nombre + ", edad=" + edad + ", antiguedad=" + antiguedad + ", secretario=" + secretario + '}';
    }
    
    
    
}
