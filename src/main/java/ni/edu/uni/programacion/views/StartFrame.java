/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.views;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import ni.edu.uni.programacion.controllers.PnlCalculadoraController;
import ni.edu.uni.programacion.controllers.PnlTemperatureController;
import ni.edu.uni.programacion.controllers.PnlVehicleController;
import ni.edu.uni.programacion.views.panels.PnlCalculadora;
import ni.edu.uni.programacion.views.panels.PnlConversionTemplate;
import ni.edu.uni.programacion.views.panels.PnlVehicle;

/**
 *
 * @author yasser.membreno
 */
public class StartFrame extends javax.swing.JFrame {

    private PnlCalculadora pnlCalculadora;
    private PnlCalculadoraController pnlCalculadoraController;
    private PnlConversionTemplate pnlCTTemperature;
    private PnlTemperatureController pnlTemperatureController;
    private PnlVehicle pnlVehicle;
    private PnlVehicleController pnlVehicleController;

    /**
     * Creates new form StartFrame
     */
    public StartFrame() {

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLeftButtons = new javax.swing.JPanel();
        btnCalc = new javax.swing.JButton();
        btnTemperature = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        pnlContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My App");
        getContentPane().setLayout(new java.awt.BorderLayout(3, 2));

        pnlLeftButtons.setBackground(new java.awt.Color(153, 153, 153));
        pnlLeftButtons.setPreferredSize(new java.awt.Dimension(120, 100));
        pnlLeftButtons.setLayout(new java.awt.GridLayout(3, 1, 2, 2));

        btnCalc.setText("Calculadora");
        btnCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcActionPerformed(evt);
            }
        });
        pnlLeftButtons.add(btnCalc);

        btnTemperature.setText("Temperatura");
        btnTemperature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTemperatureActionPerformed(evt);
            }
        });
        pnlLeftButtons.add(btnTemperature);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-file.png"))); // NOI18N
        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        pnlLeftButtons.add(jButton3);

        getContentPane().add(pnlLeftButtons, java.awt.BorderLayout.LINE_START);

        pnlContent.setBackground(new java.awt.Color(255, 255, 255));
        pnlContent.setLayout(new java.awt.BorderLayout());
        getContentPane().add(pnlContent, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(416, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcActionPerformed

        if (pnlCalculadora == null) {
            pnlCalculadora = new PnlCalculadora();
            pnlCalculadoraController = new PnlCalculadoraController(pnlCalculadora);
        }
        addComponent(pnlCalculadora);
    }//GEN-LAST:event_btnCalcActionPerformed

    private void addComponent(JComponent component) {
        pnlContent.removeAll();
        pnlContent.add(component, BorderLayout.CENTER);
        pnlContent.repaint();
        this.validate();
    }

    private void btnTemperatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTemperatureActionPerformed

        if (pnlCTTemperature == null) {
            pnlCTTemperature = new PnlConversionTemplate();
            pnlTemperatureController = new PnlTemperatureController(pnlCTTemperature);
        }
        addComponent(pnlCTTemperature);
    }//GEN-LAST:event_btnTemperatureActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            if (pnlVehicle == null) {
                pnlVehicle = new PnlVehicle();
                pnlVehicleController = new PnlVehicleController(pnlVehicle);
            }
            
            addComponent(pnlVehicle);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StartFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalc;
    private javax.swing.JButton btnTemperature;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlLeftButtons;
    // End of variables declaration//GEN-END:variables
}
