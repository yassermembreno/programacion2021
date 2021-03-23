/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.uni.edu.programacion.views;

import java.awt.BorderLayout;
import javax.swing.JComponent;
import ni.uni.edu.programacion.controllers.CalculatorController;
import ni.uni.edu.programacion.controllers.TemperatureController;
import ni.uni.edu.programacion.views.panels.PnlCalculator;
import ni.uni.edu.programacion.views.panels.PnlConversionTemplate;

/**
 *
 * @author Sistemas-05
 */
public class FrmConversionApp extends javax.swing.JFrame {
    private PnlCalculator pnlCalculator;
    private CalculatorController calculatorController;
    
    private PnlConversionTemplate pnlTemperature;
    private TemperatureController temperatureController;
    
    /**
     * Creates new form FrmConversionApp
     */
    public FrmConversionApp() {
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
        btnCalculator = new javax.swing.JButton();
        btnTemperature = new javax.swing.JButton();
        btnCurrency = new javax.swing.JButton();
        pnlContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conversion App");
        getContentPane().setLayout(new java.awt.BorderLayout(3, 0));

        pnlLeftButtons.setBackground(new java.awt.Color(204, 204, 204));
        pnlLeftButtons.setPreferredSize(new java.awt.Dimension(120, 300));
        pnlLeftButtons.setLayout(new java.awt.GridLayout(3, 1));

        btnCalculator.setText("Calculadora");
        btnCalculator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculatorActionPerformed(evt);
            }
        });
        pnlLeftButtons.add(btnCalculator);

        btnTemperature.setText("Temperatura");
        btnTemperature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTemperatureActionPerformed(evt);
            }
        });
        pnlLeftButtons.add(btnTemperature);

        btnCurrency.setText("Moneda");
        pnlLeftButtons.add(btnCurrency);

        getContentPane().add(pnlLeftButtons, java.awt.BorderLayout.LINE_START);

        pnlContent.setBackground(new java.awt.Color(255, 255, 255));
        pnlContent.setLayout(new java.awt.BorderLayout());
        getContentPane().add(pnlContent, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(416, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalculatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculatorActionPerformed
       if(pnlCalculator == null){
           pnlCalculator = new PnlCalculator();
           calculatorController = new CalculatorController(pnlCalculator);
       }
       
        addComponent(pnlCalculator);
    }//GEN-LAST:event_btnCalculatorActionPerformed

    private void addComponent(JComponent component) {
        pnlContent.removeAll();        
        pnlContent.add(component, BorderLayout.CENTER);
        validate();
        repaint();
    }

    private void btnTemperatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTemperatureActionPerformed
        if(pnlTemperature == null){
            pnlTemperature = new PnlConversionTemplate();
            temperatureController = new TemperatureController(pnlTemperature);
        }
        addComponent(pnlTemperature);
    }//GEN-LAST:event_btnTemperatureActionPerformed

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
            java.util.logging.Logger.getLogger(FrmConversionApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmConversionApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmConversionApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmConversionApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmConversionApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculator;
    private javax.swing.JButton btnCurrency;
    private javax.swing.JButton btnTemperature;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlLeftButtons;
    // End of variables declaration//GEN-END:variables
}
