/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author yasser.membreno
 */
public class MainFrame extends JFrame{

    private JLabel titleLabel;
    
    public MainFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,400);
        setTitle("My first Frame");
        
        titleLabel = new JLabel("Hola Mundo desde Swing!");
        
        getContentPane().add(titleLabel);
        setVisible(true);
    }   

    public static void main(String args[]){
        SwingUtilities.invokeLater(() -> new MainFrame());
    }
}
