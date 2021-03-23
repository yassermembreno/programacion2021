/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.backend.dao.implementation;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import ni.edu.uni.programacion.backend.dao.VehicleDao;
import ni.edu.uni.programacion.backend.pojo.Vehicle;

/**
 *
 * @author yasser.membreno
 */
public class JsonVehicleDaoImpl extends RandomTemplate implements VehicleDao{       
    private final int SIZE = 800;    
    private Gson gson;    
    
    public JsonVehicleDaoImpl() throws FileNotFoundException {
        super(new File("vehicleJson.head"), new File("vehicleJson.dat"));        
        gson = new Gson();
        
    }    
    
    @Override
    public Vehicle findById(int id) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Vehicle> findByStatus(String status) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Vehicle t) throws IOException {
        
        getCustomRandom().getRafH().seek(0);
        int n = getCustomRandom().getRafH().readInt();
        int k = getCustomRandom().getRafH().readInt();
                
        long posD = k*SIZE;        
        getCustomRandom().getRafD().seek(posD);
        
        getCustomRandom().getRafD().writeInt(++k);//id
        getCustomRandom().getRafD().writeUTF(gson.toJson(t));//Vehicle json
        
        long posH = 8 + (n*8);
        getCustomRandom().getRafH().seek(posH);
        
        getCustomRandom().getRafH().writeInt(k);
        getCustomRandom().getRafH().writeInt(t.getStockNumber());
        
        getCustomRandom().getRafH().seek(0);
        getCustomRandom().getRafH().writeInt(++n);
        getCustomRandom().getRafH().writeInt(k);
        
        close();
        
    }

    @Override
    public int update(Vehicle t) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Vehicle t) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Vehicle> getAll() throws IOException {
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle = null;
        
        getCustomRandom().getRafH().seek(0);
        int n = getCustomRandom().getRafH().readInt();        
        
        for(int i = 0; i < n; i++){
            long posH = 8 + (i*8);
            getCustomRandom().getRafH().seek(posH);
            
            int id = getCustomRandom().getRafH().readInt();
            
            if(id <= 0){
                continue;
            }
            
            long posD = (id - 1)*SIZE;
            getCustomRandom().getRafD().seek(posD);
            
            getCustomRandom().getRafD().readInt();                   
            vehicle = gson.fromJson(getCustomRandom().getRafD().readUTF(), Vehicle.class);
            
            vehicles.add(vehicle);            
        }
        
        return vehicles;
    }
    
}
