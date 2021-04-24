/*
 * Ejercicio Realizado Para el Modulo Acceso a Datos
 * Curso Desarrollo de aplicaciones Multiplataforma
 * IES Juan Bosco
 */
package vista;

import Alumno.AlumnoBean;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose Antonio Acevedo Paredes
 */
public class Principal extends javax.swing.JFrame {

    PantallaAnadirAlumno anadir = new PantallaAnadirAlumno(this, rootPaneCheckingEnabled);

    /**
     *
     */
    public Principal() {
        initComponents();
        this.jTableAlumnos.setModel(modelo);
        this.modelo.addColumn("DNI");//estas son las cabeceras o columnas
        this.modelo.addColumn("Nombre");
        this.modelo.addColumn("Apellidos");
        this.modelo.addColumn("Direccion");
        this.modelo.addColumn("Fecha Nacimiento");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    DefaultTableModel modelo = new DefaultTableModel();
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPeronalizado1 = new PanelPersonalizado.PanelPeronalizado();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAlumnos = new javax.swing.JTable();
        jButtonConsulta = new javax.swing.JButton();
        jButtonAnadirAlumno = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelPeronalizado1.setRutaImagen(new java.io.File("C:\\Users\\josea\\Documents\\FP\\FpGitHud\\TareasAD\\Tema7\\proyectos\\PanelAlumnos\\Imagenes\\imagen.png"));

        javax.swing.GroupLayout panelPeronalizado1Layout = new javax.swing.GroupLayout(panelPeronalizado1);
        panelPeronalizado1.setLayout(panelPeronalizado1Layout);
        panelPeronalizado1Layout.setHorizontalGroup(
            panelPeronalizado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
        );
        panelPeronalizado1Layout.setVerticalGroup(
            panelPeronalizado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 63, Short.MAX_VALUE)
        );

        jTableAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableAlumnos);

        jButtonConsulta.setText("Consultar Datos.");
        jButtonConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultaActionPerformed(evt);
            }
        });

        jButtonAnadirAlumno.setText("Añadir Alumno");
        jButtonAnadirAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnadirAlumnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(203, 203, 203)
                                .addComponent(panelPeronalizado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButtonConsulta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAnadirAlumno)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPeronalizado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConsulta)
                    .addComponent(jButtonAnadirAlumno))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultaActionPerformed
        AlumnoBean alumnos = new AlumnoBean();
        
        try {
            for (int i = 0; i < 100; i++) {
                alumnos.seleccionarFila(i);
                // crea un objeto y lo aloja en la fila "Row" con los datos de las areas de texto
                modelo.addRow(new Object[]{alumnos.getDNI(), alumnos.getNombre(),
                    alumnos.getApellidos(), alumnos.getDireccion(), alumnos.getFechaNac()});
            }
        } catch (Exception e) {
            System.out.println("fin linea");
        }

    }//GEN-LAST:event_jButtonConsultaActionPerformed

    private void jButtonAnadirAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnadirAlumnoActionPerformed
        anadir.setVisible(true);
    }//GEN-LAST:event_jButtonAnadirAlumnoActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnadirAlumno;
    private javax.swing.JButton jButtonConsulta;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAlumnos;
    private PanelPersonalizado.PanelPeronalizado panelPeronalizado1;
    // End of variables declaration//GEN-END:variables
}
