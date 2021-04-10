/*
 * Ejercicio Realizado Para el Modulo Acceso a Datos
 * Curso Desarrollo de aplicaciones Multiplataforma
 * IES Juan Bosco
 */

package utilExistDB;


import java.util.logging.Level;
import java.util.logging.Logger;
//import org.exist.Database;
//import org.xmldb.api.DatabaseManager;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;

/**
 *
 * @author Jose Antonio Acevedo Paredes
 */
public class DriverExistDB {
    
    
   //valores para la conexión a la base de datos db: driver, uri, usuario y password
    static String driver = "org.exist.xmldb.DatabaseImpl"; //Driver para eXist
    static String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db"; //URI colección principal
    static String usuario = "admin"; //Usuario
    static String usuarioClave = "1234"; //Clave
    static Collection coleccion = null;
    
    public static Collection conectarDB(){
    
        try {
            Class cl = Class.forName(driver);//carga del dtiver
            Database database = (Database) cl.newInstance();//instancia de la BD
            DatabaseManager.registerDatabase(database);//Registro del driver
            coleccion = DatabaseManager.getCollection(URI,usuario,usuarioClave);
            
            return coleccion;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | XMLDBException ex) {
            System.out.println("fallo al conectar");
        }
        return null;
    
    }
    
}
