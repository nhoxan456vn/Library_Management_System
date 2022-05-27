/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PublisherDAO;
import DTO.PublisherDTO;
import java.util.ArrayList;

/**
 *
 * @author Manh Hai
 */
public class PublisherBUS {
    private static ArrayList<PublisherDTO> arrPublisher = new ArrayList<>();
    private PublisherDAO publisherDAO = new PublisherDAO();

    public PublisherBUS() {
        arrPublisher = publisherDAO.readDB();
    }
    
    public void readDB(){
        arrPublisher = publisherDAO.readDB();
    }
    
    public Boolean add(PublisherDTO publisher){
        Boolean check = publisherDAO.add(publisher);
        if (check){
            arrPublisher.add(publisher);
        }
        return check;
    }
    
    public Boolean del(int id){
        Boolean check = publisherDAO.del(id);
        if (check){
            for (PublisherDTO publisher : arrPublisher){
                if (publisher.getId() == id){
                    arrPublisher.remove(publisher);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean upd(PublisherDTO publisher){
        Boolean check = publisherDAO.upd(publisher);  
        if (check){
            for (PublisherDTO p : arrPublisher){
                if (p.getId() == publisher.getId()){
                    arrPublisher.set(arrPublisher.indexOf(p), publisher);
                    break;
                }
            }
        } 
        return check;
    }
    
    public ArrayList<PublisherDTO> getArrPublisher() {
        readDB();
        return arrPublisher;
    }
    
    public int getArrSize(){
        return arrPublisher.size();
    }
}
