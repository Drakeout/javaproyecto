/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import java.awt.Dimension;
import java.awt.Toolkit;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 *
 * @author felip
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        

        LocalDate hoy = LocalDate.now();
        String nombre = System.getProperty("user.name");

        String formattedDate = hoy.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));

        this.lblFecha.setText(formattedDate);
        this.lblNombre.setText(nombre);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFecha = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        btnCalendario = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnAnadir = new javax.swing.JMenu();
        mnAgregarTarea = new javax.swing.JMenuItem();
        mnAgregarObjetivo = new javax.swing.JMenuItem();
        mnListarTareas = new javax.swing.JMenu();
        mbListarTareas = new javax.swing.JMenuItem();
        mnListarObjetivos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFecha.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblFecha.setText("Fecha actual");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Hola!");

        lblNombre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNombre.setText("nombre");

        btnCalendario.setText("Calendario");
        btnCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalendarioActionPerformed(evt);
            }
        });

        mnAnadir.setText("Añadir");
        mnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAnadirActionPerformed(evt);
            }
        });

        mnAgregarTarea.setText("Agregar Tarea");
        mnAgregarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAgregarTareaActionPerformed(evt);
            }
        });
        mnAnadir.add(mnAgregarTarea);

        mnAgregarObjetivo.setText("Agregar Objetivo");
        mnAgregarObjetivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAgregarObjetivoActionPerformed(evt);
            }
        });
        mnAnadir.add(mnAgregarObjetivo);

        jMenuBar1.add(mnAnadir);

        mnListarTareas.setText("Listas");

        mbListarTareas.setText("Listar Tareas");
        mbListarTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbListarTareasActionPerformed(evt);
            }
        });
        mnListarTareas.add(mbListarTareas);

        mnListarObjetivos.setText("Listar Objetivos");
        mnListarObjetivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnListarObjetivosActionPerformed(evt);
            }
        });
        mnListarTareas.add(mnListarObjetivos);

        jMenuBar1.add(mnListarTareas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFecha)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblNombre)))
                .addContainerGap(245, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnAgregarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAgregarTareaActionPerformed
        new VentanaAgregarTarea().setVisible(true);
    }//GEN-LAST:event_mnAgregarTareaActionPerformed

    private void btnCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalendarioActionPerformed
        new VentanaCalendario().setVisible(true);
    }//GEN-LAST:event_btnCalendarioActionPerformed

    private void mnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAnadirActionPerformed

    }//GEN-LAST:event_mnAnadirActionPerformed

    private void mnAgregarObjetivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAgregarObjetivoActionPerformed
        new VentanaAgregarObjetivo().setVisible(true);
    }//GEN-LAST:event_mnAgregarObjetivoActionPerformed

    private void mbListarTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbListarTareasActionPerformed
        new VentanaListarTareas().setVisible(true);
    }//GEN-LAST:event_mbListarTareasActionPerformed

    private void mnListarObjetivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnListarObjetivosActionPerformed
        new VentanaListarObjetivos().setVisible(true);
    }//GEN-LAST:event_mnListarObjetivosActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalendario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JMenuItem mbListarTareas;
    private javax.swing.JMenuItem mnAgregarObjetivo;
    private javax.swing.JMenuItem mnAgregarTarea;
    private javax.swing.JMenu mnAnadir;
    private javax.swing.JMenuItem mnListarObjetivos;
    private javax.swing.JMenu mnListarTareas;
    // End of variables declaration//GEN-END:variables
}