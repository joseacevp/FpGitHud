/*
 * Ejercicio Realizado Para el Modulo Acceso a Datos
 * Curso Desarrollo de aplicaciones Multiplataforma
 * IES Juan Bosco
 */
package tema5db4o;



/**
 *
 * @author Jose Antonio Acevedo Paredes
 */
public class Tema5DB4o {

    /** 
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //la base de datos se alojará el proyecto dentro  de la carpeta bd
        File fichero = new File("./bd/BDJefes.db");
        ObjectContainer baseDatos;
        if (!fichero.exist()) {
            baseDatos = Db4oEmbedded.openFile("./bd/BDJefes");
        }
//Entradas de datos de prueba.
        Secretario h1 = new Secretario("Gustavo", 30);
        Jefe j1 = new Jefe("Ángel", 5, 53, h1);
        baseDatos.store(h1);
//también podemos escribir
        baseDatos.store(new Jefe("Nieves", 3, 45, new Secretario("Iván", 33)));
        baseDatos.store(new Jefe("Jesús", 10, 50, new Secretario("Noelia", 31)));
        baseDatos.store(new Jefe("Dolores", 15, 63, new Secretario("Sergio", 47)));
        baseDatos.store(new Jefe("Vicki", 3, 45, null));  //no tiene secretario
        baseDatos.store(new Jefe("Fátima", 25, 63, new Secretario("Lidia", 57)));
        baseDatos.store(new Jefe("Juan Luís", 13, 25, null));  //no tiene secretario
        baseDatos.store(new Jefe("Elena", 10, 42, new Secretario("David", 19)));
        baseDatos.store(new Jefe("Miguel", 20, 45, new Secretario("Paula", 23)));
        baseDatos.store(new Jefe("Jesús", 9, 44, new Secretario("Rubén", 32)));
        baseDatos.close();
    }
    
//La información que se trata de representar para los Jefes es el nombre ,
    //numero de años en la empresas , la edad y el nombre y edad de su secretario
    

}
