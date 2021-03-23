/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.backend.dao.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author yasser.membreno
 */
public class CustomRandom {

    private RandomAccessFile rafH;
    private RandomAccessFile rafD;

    public CustomRandom(File fileHead, File fileData) throws FileNotFoundException, IOException {
        rafH = new RandomAccessFile(fileHead, "rw");
        rafD = new RandomAccessFile(fileData, "rw");

        if (fileHead.length() == 0) {
            rafH.writeInt(0);
            rafH.writeInt(0);
        }
    }

    public void close() throws IOException{
        if(rafH != null){
            rafH.close();
        }
        
        if(rafD != null){
            rafD.close();
        }
        
    }
    
    public RandomAccessFile getRafH() {
        return rafH;
    }

    public RandomAccessFile getRafD() {
        return rafD;
    }
}
