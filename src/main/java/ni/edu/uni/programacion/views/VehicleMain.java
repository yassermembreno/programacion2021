/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.views;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ni.edu.uni.programacion.backend.dao.implementation.JsonVehicleDaoImpl;
import ni.edu.uni.programacion.backend.pojo.Vehicle;

/**
 *
 * @author Sistemas-05
 */
public class VehicleMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            JsonVehicleDaoImpl vjdao = new JsonVehicleDaoImpl();
            
            Vehicle v = new Vehicle(12, 2021, "Toyota", "Hilux", "SRV", 
                    "H12H334J23K", "Blue", "Gray", "0", 55000, Vehicle.Transmission.MANUAL,
                    "2.4L Gas", null, "Active");
            
            //vjdao.create(v);
            
            List<Vehicle> vehicles = (List<Vehicle>) vjdao.getAll();
            for(Vehicle ve : vehicles){
                System.out.println(ve.toString());
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VehicleMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VehicleMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
