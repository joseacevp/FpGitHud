/*
 * Ejercicio Realizado Para el Modulo Acceso a Datos
 * Curso Desarrollo de aplicaciones Multiplataforma
 * IES Juan Bosco
 */
package vista;

import Alumno.AlumnoBean;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose Antonio Acevedo Paredes
 */
public class AnadirAlumnos extends javax.swing.JDialog implements AlumnoBean.BDModificadaListener {

    public AnadirAlumnos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        alumnoBean1 = new Alumno.AlumnoBean();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        areaTextoDni = new javax.swing.JTextField();
        areaTextoNombre = new javax.swing.JTextField();
        areaTextoApellidos = new javax.swing.JTextField();
        botonGrabarAlumno = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        areaTextoDireccion = new javax.swing.JTextField();
        calendarioFechaNacimiento = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("DNI:");

        jLabel2.setText("NOMBRE:");

        jLabel3.setText("APELLIDOS:");

        jLabel4.setText("FECHA DE NACIMIENTO:");

        botonGrabarAlumno.setText("Grabar");
        botonGrabarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGrabarAlumnoActionPerformed(evt);
            }
        });

        jLabel5.setText("DIRECCION:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(369, Short.MAX_VALUE)
                        .addComponent(botonGrabarAlumno))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(calendarioFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(areaTextoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                                    .addComponent(areaTextoApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                                    .addComponent(areaTextoDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                                .addComponent(areaTextoDni, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(areaTextoDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(areaTextoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(areaTextoApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(areaTextoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(calendarioFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botonGrabarAlumno)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGrabarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGrabarAlumnoActionPerformed

        try {
            alumnoBean1 = new AlumnoBean();
            alumnoBean1.setDNI(areaTextoDni.getText());
            alumnoBean1.setNombre(areaTextoNombre.getText());
            alumnoBean1.setApellidos(areaTextoApellidos.getText());
            alumnoBean1.setDireccion(areaTextoDireccion.getText());

            int ayo = calendarioFechaNacimiento.getCalendar().get(Calendar.YEAR);
            int mes = calendarioFechaNacimiento.getCalendar().get(Calendar.MONTH);
            int dia = calendarioFechaNacimiento.getCalendar().get(Calendar.DAY_OF_MONTH);
            alumnoBean1.setFechaNac(Date.valueOf(String.valueOf(ayo) + "-" + String.valueOf(mes) + "-" + String.valueOf(dia)));
            //alumnos.setFechaNac(Date.valueOf("1987-06-05"));
            alumnoBean1.addBDModificadaListener(this);//oyente de modificacion de la base de datos
            alumnoBean1.addAlumno();

        } catch (NullPointerException nulles) {
            System.out.println("fallo");
            this.dispose();
        } catch (IllegalArgumentException | ClassNotFoundException datomal) {
            JOptionPane.showMessageDialog(null, "Datos erroneos", "aviso", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
        this.areaTextoDni.setText("");
        this.areaTextoNombre.setText("");
        this.areaTextoApellidos.setText("");
        this.areaTextoDireccion.setText("");

        //JOptionPane.showMessageDialog(null, "Añadido correctamente.", "aviso", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_botonGrabarAlumnoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AnadirAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnadirAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnadirAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnadirAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AnadirAlumnos dialog = new AnadirAlumnos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Alumno.AlumnoBean alumnoBean1;
    private javax.swing.JTextField areaTextoApellidos;
    private javax.swing.JTextField areaTextoDireccion;
    private javax.swing.JTextField areaTextoDni;
    private javax.swing.JTextField areaTextoNombre;
    private javax.swing.JButton botonGrabarAlumno;
    private com.toedter.calendar.JDateChooser calendarioFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables

    @Override
    public void capturarBDModificada(AlumnoBean.BDModificadaEvent bdme) {
        System.out.println("se añadio un alumno");
        JOptionPane.showMessageDialog(null, "Se ha añadido un elemento a la base de datos", "evento", JOptionPane.INFORMATION_MESSAGE);
    }
}
