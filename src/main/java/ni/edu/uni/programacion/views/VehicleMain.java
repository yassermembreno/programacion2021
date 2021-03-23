/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.views;

import java.io.FileNotFoundException;
import java.io.IOException;
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
            
            Vehicle v = new Vehicle(1234, 2015, "Jeep", "Wrangler", "Gladiator", 
                    "1T22J3L3JKKD", "RED", "BLACK", "25000", 75000F, 
                    Vehicle.Transmission.AUTOMATIC, "3.6 BItURBO", null, "ACTIVE");
            
            jvdao.create(v);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VehicleMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VehicleMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
