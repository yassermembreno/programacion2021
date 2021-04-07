/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.views.models;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Observer;
import javax.swing.table.AbstractTableModel;
import ni.edu.uni.programacion.backend.pojo.Vehicle;

/**
 *
 * @author Sistemas-05
 */
public class VehicleTableModel extends AbstractTableModel implements PropertyChangeListener{
    private List<Vehicle> data;
    private final String[] columnNames;

    public VehicleTableModel(List<Vehicle> data, String[] columnNames) {
        this.data = data;
        this.columnNames = columnNames;
    }
    
    public void add(Vehicle v){
        this.data.add(v);
    }
        
    @Override
    public int getRowCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames == null ? 0 : columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data == null ? null : data.isEmpty() ? null : data.get(rowIndex).asArray()[columnIndex];
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        add((Vehicle)evt.getNewValue());
        fireTableDataChanged();
    }
    
    
}
