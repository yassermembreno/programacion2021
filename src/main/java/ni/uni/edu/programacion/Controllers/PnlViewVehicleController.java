/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.uni.edu.programacion.Controllers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import ni.edu.uni.programacion.backend.dao.implementation.JsonVehicleDaoImpl;
import ni.edu.uni.programacion.backend.pojo.Vehicle;
import ni.uni.edu.programacion.component.model.VehicleTableModel;
import ni.uni.edu.programacion.views.panels.PnlViewVehicle;

/**
 *
 * @author Sistemas-05
 */
public class PnlViewVehicleController {

    private PnlViewVehicle pnlViewVehicle;
    private JsonVehicleDaoImpl jsonVehicleDaoImpl;
    private VehicleTableModel tblViewVehicleModel;
    private List<Vehicle> vehicles;
    private String[] HEADERS = new String[]{"StockNumber", "Year", "Make", "Model",
        "Style", "Vin", "Exterior color", "Interior color", "Miles", "Price", "Transmission",
        "Engine", "Image", "Status"};
    private TableRowSorter<VehicleTableModel> tblRowSorter;

    public PnlViewVehicleController(PnlViewVehicle pnlViewVehicle) {
        this.pnlViewVehicle = pnlViewVehicle;
        initComponent();
    }

    private void initComponent() {
        try {
            jsonVehicleDaoImpl = new JsonVehicleDaoImpl();

            loadTable();
            pnlViewVehicle.getTxtFinder().addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    txtFinderKeyTyped(e);
                }
            });

        } catch (IOException ex) {
            Logger.getLogger(PnlViewVehicleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void txtFinderKeyTyped(KeyEvent e) {
        RowFilter<VehicleTableModel, Object> rf = null;
        
        rf = RowFilter.regexFilter("(?i)" + pnlViewVehicle.getTxtFinder().getText(), 0,1,2,3,4,5,6,7,8,9);
        tblRowSorter.setRowFilter(rf);
    }

    private void loadTable() throws IOException {
        vehicles = jsonVehicleDaoImpl.getAll().stream().collect(Collectors.toList());
        tblViewVehicleModel = new VehicleTableModel(vehicles, HEADERS);
        tblRowSorter = new TableRowSorter<>(tblViewVehicleModel);

        pnlViewVehicle.getTblViewVehicle().setModel(tblViewVehicleModel);
        pnlViewVehicle.getTblViewVehicle().setRowSorter(tblRowSorter);
    }

//    private Object[][] getData() throws IOException {
//        vehicles = jsonVehicleDaoImpl.getAll().stream().collect(Collectors.toList());
//        if (vehicles == null || vehicles.isEmpty()) {
//            return new Object[][]{null};
//        }
//
//        Object[][] data = new Object[vehicles.size()][vehicles.get(0).asArray().length];
//
//        IntStream.range(0, vehicles.size()).forEach(i -> {
//            data[i] = vehicles.get(i).asArray();
//        });
//
//        return data;
//    }

}
