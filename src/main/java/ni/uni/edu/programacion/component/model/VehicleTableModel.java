/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.uni.edu.programacion.component.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import ni.edu.uni.programacion.backend.pojo.Vehicle;

/**
 *
 * @author Sistemas-05
 */
public class VehicleTableModel extends AbstractTableModel {
    private List<Vehicle> vehicles;
    private String[] columnNames;

    public VehicleTableModel(List vehicles, String[] columnNames) {
        this.vehicles = vehicles;
        this.columnNames = columnNames;
    }
    
    
    @Override
    public int getRowCount() {
        return vehicles == null ? 0 : vehicles.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames == null ? 0 : columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return vehicles.get(rowIndex).asArray()[columnIndex];
    }
    
}
