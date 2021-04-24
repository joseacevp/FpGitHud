/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Alumno.AlumnoBean;
import controlador.AccedeBD;
import vista.Principal;

/**
 *
 * @author usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Principal pantallaPrincipal = new Principal();
        pantallaPrincipal.setVisible(true);
        AccedeBD gestion = new AccedeBD();

        //gestion.anade();
        gestion.listado();
    }

}
