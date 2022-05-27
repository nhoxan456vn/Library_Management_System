/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.SupplierDAO;
import DTO.SupplierDTO;
import java.util.ArrayList;

/**
 *
 * @author Manh Hai
 */
public class SupplierBUS {
    private static ArrayList<SupplierDTO> arrSupplier = new ArrayList<>();
    private SupplierDAO supplierDAO = new SupplierDAO();

    public SupplierBUS() {
        arrSupplier = supplierDAO.readDB();
    }
    
    public void readDB(){
        arrSupplier = supplierDAO.readDB();
    }
    
    public Boolean add(SupplierDTO supplier){
        Boolean check = supplierDAO.add(supplier);
        if (check){
            arrSupplier.add(supplier);
        }
        return check;
    }
    
    public Boolean del(int id){
        Boolean check = supplierDAO.del(id);
        if (check){
            for (SupplierDTO supplier : arrSupplier){
                if (supplier.getId() == id){
                    arrSupplier.remove(supplier);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean upd(SupplierDTO supplier){
        Boolean check = supplierDAO.upd(supplier);  
        if (check){
            for (SupplierDTO s : arrSupplier){
                if (s.getId() == supplier.getId()){
                    arrSupplier.set(arrSupplier.indexOf(s), supplier);
                    break;
                }
            }
        } 
        return check;
    }
    
    public ArrayList<SupplierDTO> getArrSupplier() {
        readDB();
        return arrSupplier;
    }
    
    public int getArrSize(){
        return arrSupplier.size();
    }
}
