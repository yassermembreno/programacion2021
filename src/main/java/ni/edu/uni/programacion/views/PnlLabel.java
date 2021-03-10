/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.views;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author yasser.membreno
 */
public class PnlLabel extends JPanel {
    private JLabel lblTitle;

    public PnlLabel() {
        initComponent();
    }
    
    private void initComponent(){
        setLayout(new FlowLayout(0));
        setBackground(Color.gray);
        lblTitle = new JLabel("Hello world from Swing");
        add(lblTitle);
    }
    
}
