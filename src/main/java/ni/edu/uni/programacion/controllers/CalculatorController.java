/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ni.edu.uni.programacion.views.panels.PnlCalculator;

/**
 *
 * @author Sistemas-05
 */
public class CalculatorController implements ActionListener{
    private PnlCalculator pnlCalculator;

    public CalculatorController(PnlCalculator pnlCalculator) {
        this.pnlCalculator = pnlCalculator;
        initComponent();
    }
    
    private void initComponent(){
        pnlCalculator.getBtnCalc().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("Calcular")){
            double n1,n2;
            n1 = Double.parseDouble(pnlCalculator.getTxtNumber1().getText());
            n2 = Double.parseDouble(pnlCalculator.getTxtNumber2().getText());
            pnlCalculator.getTxtResult().setText(String.valueOf(suma(n1,n2)));
        }
    }
    
    private double suma(double a, double b){
        return (a+b);
    }
    
}
