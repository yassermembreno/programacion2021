/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.views;

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
    
    private void initComponent(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("My first Frame");
        setSize(300,400);
        //pnlLabel
        pnlLabel = new PnlLabel();
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(pnlLabel, BorderLayout.NORTH);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyFrame());
        
//        SwingUtilities.invokeLater(new Runnable(){
//            public void run(){
//                new MyFrame();
//            }
//        });
    }
}
