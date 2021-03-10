/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.uni.edu.programacion.views;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author yasser.membreno
 */
public class MyFrame extends JFrame {

    private PnlLabel pnlLabel;

    public MyFrame() {
        initComponent();
    }

    private void initComponent() {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//permite cerrar la ventana
        setTitle("My first Window");//permite agregar titulo a la ventana
        setSize(300, 400);//permite cambiar la dimension de la ventana

        pnlLabel = new PnlLabel();
        //getContentPane().setLayout(new BorderLayout());
        getContentPane().add(pnlLabel, BorderLayout.NORTH);
        setVisible(true);//muestra la ventana
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyFrame());
    }
}
