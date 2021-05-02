/*
 * Ejercicio Realizado Para el Modulo Acceso a Datos
 * Curso Desarrollo de aplicaciones Multiplataforma
 * IES Juan Bosco
 */
package PanelPersonalizado;

import java.awt.Graphics;
import java.io.File;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Jose Antonio Acevedo Paredes
 */
public class PanelPeronalizado extends JPanel implements Serializable {

    //ruta de la imagen para añadir al apanel
    private File rutaImagen;

    //creamos javabeans extends JPanel y implement serializable
    //construptor sin parametros
    public PanelPeronalizado() {
    }

    //metodos get y set
    //copilar y construir 
    //añadir a la paleta.
    public File getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(File rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    //redifine el componente para pintar el fondo del panel
    //click en insertar codigo y redifinir Jcomponent
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
       //if para evitar excepcion con null
        if (rutaImagen.exists() && rutaImagen!=null) {
            //con el objeto g de Graphics pintamos la imagen
            ImageIcon imagenFondo = new ImageIcon(rutaImagen.getAbsolutePath());
            g.drawImage(imagenFondo.getImage(), WIDTH, WIDTH, null);
        }

    }

}
