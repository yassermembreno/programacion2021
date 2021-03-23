/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.uni.edu.programacion.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import ni.uni.edu.programacion.views.panels.PnlConversionTemplate;

/**
 *
 * @author Sistemas-05
 */
public class TemperatureController {

    private PnlConversionTemplate pnlTemperature;
    private DefaultComboBoxModel<String> cmbFromModel;
    private DefaultComboBoxModel<String> cmbToModel;
    private final String TEMPERATURES[] = new String[]{"Celcius", "Fahrenheit"};

    public TemperatureController(PnlConversionTemplate pnlTemperature) {
        this.pnlTemperature = pnlTemperature;
        initComponent();
    }

    private void initComponent() {
        cmbFromModel = new DefaultComboBoxModel<>(TEMPERATURES);
        cmbToModel = new DefaultComboBoxModel<>(TEMPERATURES);

        pnlTemperature.getCmbFrom().setModel(cmbFromModel);
        pnlTemperature.getCmbTo().setModel(cmbToModel);

        pnlTemperature.getBtnConv().addActionListener(
                (ActionEvent e) -> {
                    btnConvActionPerformed(e);
                });
        pnlTemperature.getCmbFrom().addItemListener(
                (ItemEvent e) -> {
                    conversionEvent();
                });
        pnlTemperature.getCmbTo().addItemListener(
                (ItemEvent e) -> {
                    conversionEvent();
                });
    }

    private void btnConvActionPerformed(ActionEvent e) {
        conversionEvent();
    }

    private void conversionEvent() throws NumberFormatException {
        int indexFrom = pnlTemperature.getCmbFrom().getSelectedIndex();
        int indexTo = pnlTemperature.getCmbTo().getSelectedIndex();

        double value = Double.parseDouble(pnlTemperature.getTxtValue().getText());

        double result = convertTemperature(indexFrom, indexTo, value);
        pnlTemperature.getLblResult().setText("Resultado: " + result);
    }

    private double convertTemperature(int from, int to, double value) {
        switch (from) {
            case 0:
                switch (to) {
                    case 0:
                        return value;
                    case 1:
                        return celciusToFahrenheit(value);
                }
            case 1:
                switch (to) {
                    case 0:
                        return fahrenheitToCelcius(value);
                    case 1:
                        return value;
                }
        }
        return value;
    }

    private double celciusToFahrenheit(double value) {
        return (((double) 9 / 5 * value) + 32);
    }

    private double fahrenheitToCelcius(double value) {
        return (((double) 5 / 9) * (value - 32));
    }
}
