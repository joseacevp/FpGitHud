/*
 * Ejercicio Realizado Para el Modulo Acceso a Datos
 * Curso Desarrollo de aplicaciones Multiplataforma
 * IES Juan Bosco
 */
package vista;

/**
 *
 * @author Jose Antonio Acevedo Paredes
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
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
        panelPeronalizado1 = new PanelPersonalizado.PanelPeronalizado();
        botonVerAlumnos = new javax.swing.JButton();
        botonAnadirAlumno = new javax.swing.JButton();
        botonConsultarAlumno = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        panelPeronalizado2 = new PanelPersonalizado.PanelPeronalizado();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPeronalizado1.setRutaImagen(new java.io.File("C:\\Users\\josea\\Documents\\FP\\AD\\Tareas\\Tema7\\AppAlumnos\\Imagenes\\imagen.png"));

        botonVerAlumnos.setText("Ver Alumnos.");
        botonVerAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerAlumnosActionPerformed(evt);
            }
        });

        botonAnadirAlumno.setText("Añadir Alumno");
        botonAnadirAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnadirAlumnoActionPerformed(evt);
            }
        });

        botonConsultarAlumno.setText("Consultar Alumno");
        botonConsultarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultarAlumnoActionPerformed(evt);
            }
        });

        botonEliminar.setText("Eliminar Alumno");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        panelPeronalizado2.setRutaImagen(new java.io.File("C:\\Users\\josea\\Documents\\FP\\AD\\Tareas\\Tema7\\Tema7\\AppAlumnos\\Imagenes\\imagen.png"));

        javax.swing.GroupLayout panelPeronalizado2Layout = new javax.swing.GroupLayout(panelPeronalizado2);
        panelPeronalizado2.setLayout(panelPeronalizado2Layout);
        panelPeronalizado2Layout.setHorizontalGroup(
            panelPeronalizado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelPeronalizado2Layout.setVerticalGroup(
            panelPeronalizado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelPeronalizado1Layout = new javax.swing.GroupLayout(panelPeronalizado1);
        panelPeronalizado1.setLayout(panelPeronalizado1Layout);
        panelPeronalizado1Layout.setHorizontalGroup(
            panelPeronalizado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPeronalizado1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(botonVerAlumnos)
                .addGap(18, 18, 18)
                .addComponent(botonAnadirAlumno)
                .addGap(18, 18, 18)
                .addComponent(botonConsultarAlumno)
                .addGap(18, 18, 18)
                .addComponent(botonEliminar)
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(panelPeronalizado1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPeronalizado2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPeronalizado1Layout.setVerticalGroup(
            panelPeronalizado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPeronalizado1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelPeronalizado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPeronalizado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAnadirAlumno)
                    .addComponent(botonVerAlumnos)
                    .addComponent(botonConsultarAlumno)
                    .addComponent(botonEliminar))
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPeronalizado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPeronalizado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonVerAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerAlumnosActionPerformed
        VerAlumnos verAlumonos = new VerAlumnos(this, rootPaneCheckingEnabled);
        verAlumonos.setVisible(true);
    }//GEN-LAST:event_botonVerAlumnosActionPerformed

    private void botonAnadirAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnadirAlumnoActionPerformed
        AnadirAlumnos anadir = new AnadirAlumnos(this, rootPaneCheckingEnabled);
        anadir.setVisible(true);
    }//GEN-LAST:event_botonAnadirAlumnoActionPerformed

    private void botonConsultarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultarAlumnoActionPerformed
        ConsultaAlumno consulta = new ConsultaAlumno(this, rootPaneCheckingEnabled);
        consulta.setVisible(true);
    }//GEN-LAST:event_botonConsultarAlumnoActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
      EliminarAlumno eliminar = new EliminarAlumno(this, rootPaneCheckingEnabled);
        eliminar.setVisible(true);
    }//GEN-LAST:event_botonEliminarActionPerformed

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
    private Alumno.AlumnoBean alumnoBean1;
    private javax.swing.JButton botonAnadirAlumno;
    private javax.swing.JButton botonConsultarAlumno;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonVerAlumnos;
    private PanelPersonalizado.PanelPeronalizado panelPeronalizado1;
    private PanelPersonalizado.PanelPeronalizado panelPeronalizado2;
    // End of variables declaration//GEN-END:variables
}
