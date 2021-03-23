/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.uni.edu.programacion.views;

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
            JsonVehicleDaoImpl jvdao = new JsonVehicleDaoImpl();
            
            Vehicle vv = new Vehicle(123, 2014, "Nissan", "Sentra", "Sport", 
                    "VHH45II33", "RED", "BROWN", "120000", 6500f, 
                    Vehicle.Transmission.MANUAL, "1.8L", null, "Active");
            
            //jvdao.create(vv);
            List<Vehicle> vehicles = (List<Vehicle>) jvdao.getAll();
            
            for(Vehicle v : vehicles){
                System.out.println(v.toString());
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VehicleMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VehicleMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
