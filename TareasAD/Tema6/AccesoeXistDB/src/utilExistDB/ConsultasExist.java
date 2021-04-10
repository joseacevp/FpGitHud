/*
 * Ejercicio Realizado Para el Modulo Acceso a Datos
 * Curso Desarrollo de aplicaciones Multiplataforma
 * IES Juan Bosco
 */
package utilExistDB;

import java.util.ArrayList;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;

/**
 *
 * @author Jose Antonio Acevedo Paredes
 */
public class ConsultasExist {

    public static ArrayList consultar(Collection coleccion, String consulta) {
        ArrayList<String> respuesta = new ArrayList<>();

        System.out.println("consulta:\n" + consulta);
        //ejecuta la consulta
        XPathQueryService servicio;
        int i = 0;
        try {
            servicio = (XPathQueryService) coleccion.getService("XPathQueryService", "1.0");
            //llama aejecutar consulta y visualizar los datos
            ResourceSet result = servicio.query(consulta);
            System.out.println("recupera:" + result.getSize() + "  elementos....");
            //recupera  los datos del recurso
            ResourceIterator j;
            j = result.getIterator();
            if (!j.hasMoreResources()) {
                System.out.println("Consulta si resultados  \n "
                        + "es una actualizacion o no hay cambios");

            } else {
                System.out.println("\n"
                        + "***********************************");
                while (j.hasMoreResources()) {
                    Resource r = j.nextResource();
                    System.out.println((String) r.getContent());
                    respuesta.add((String) r.getContent());
                }

                System.out.println("**********************************");
                return respuesta;
            }

        } catch (XMLDBException ex) {
            System.out.println(" HA OCURRIDO UN ERROR, REVISA LOS FICHEOS DE CONSULTAS.");
            // Logger.getLogger(ConsultasExist.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
