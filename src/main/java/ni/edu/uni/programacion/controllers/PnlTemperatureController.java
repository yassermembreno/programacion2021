/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import ni.edu.uni.programacion.views.panels.PnlConversionTemplate;

/**
 *
 * @author Sistemas-05
 */
public class PnlTemperatureController {

    private PnlConversionTemplate pnlConversionTemplate;
    private DefaultComboBoxModel<String> fromCmbModel;
    private DefaultComboBoxModel<String> toCmbModel;
    private final String TEMPERATURE[] = new String[]{"Celcius", "Fahrenheit"};

    public PnlTemperatureController(PnlConversionTemplate pnlConversionTemplate) {
        this.pnlConversionTemplate = pnlConversionTemplate;
        initComponent();
    }

    private void initComponent() {
        fromCmbModel = new DefaultComboBoxModel<>(TEMPERATURE);
        toCmbModel = new DefaultComboBoxModel<>(TEMPERATURE);

        pnlConversionTemplate.getCmbFrom().setModel(fromCmbModel);
        pnlConversionTemplate.getCmbTo().setModel(toCmbModel);

        pnlConversionTemplate.getBtnConv().addActionListener(
                (ActionEvent e) -> {
                    btnConvActionPerformed(e);
                });

        pnlConversionTemplate.getCmbFrom().addItemListener(
                (ItemEvent e) -> {
                    conversionEvent();
                });
        pnlConversionTemplate.getCmbTo().addItemListener(
                (ItemEvent e) -> {
                    conversionEvent();
                });
    }

    private void btnConvActionPerformed(ActionEvent e) {
        conversionEvent();
    }

    private void conversionEvent() throws NumberFormatException {
        int indexFrom = pnlConversionTemplate.getCmbFrom().getSelectedIndex();
        int indexTo = pnlConversionTemplate.getCmbTo().getSelectedIndex();
        double value = Double.parseDouble(
                pnlConversionTemplate.getTxtValue().getText());

        double result = convertirTemperature(value, indexFrom, indexTo);
        pnlConversionTemplate.getLblResult().setText("Resultado: " + result);
    }

    private double convertirTemperature(double value, int from, int to) {
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
