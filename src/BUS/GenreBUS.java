/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.GenreDAO;
import DTO.GenreDTO;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Manh Hai
 */
public class GenreBUS {
    private static ArrayList<GenreDTO> arrGenre = new ArrayList<>();
    private GenreDAO genreDAO = new GenreDAO();

    public GenreBUS() {
        arrGenre = genreDAO.readDB();
    }
    
    public void readDB(){
        arrGenre = genreDAO.readDB();
    }
    
    public Boolean add(GenreDTO genre){
        Boolean check = genreDAO.add(genre);
        if (check){
            arrGenre.add(genre);
        }
        return check;
    }
    
    public Boolean del(int id){
        Boolean check = genreDAO.del(id);
        if (check){
            for (GenreDTO genre : arrGenre){
                if (genre.getId() == id){
                    arrGenre.remove(genre);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean upd(GenreDTO genre){
        Boolean check = genreDAO.upd(genre);  
        if (check){
            for (GenreDTO g : arrGenre){
                if (g.getId() == genre.getId()){
                    arrGenre.set(arrGenre.indexOf(g), genre);
                    break;
                }
            }
        } 
        return check;
    }
    
    public ArrayList<GenreDTO> getArrGenre() {
        readDB();
        return arrGenre;
    }
    
    public int getArrSize(){
        return arrGenre.size();
    }
    
    public HashMap<String, Integer> getGenresMap() {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (GenreDTO genreDTO : arrGenre) {
            map.put(genreDTO.getName(), genreDTO.getId());
        }
        
        return map;
    }

    public GenreDTO getGenreByID(int genre_id) {
        if(genreDAO.hasGenreID(genre_id)) {
            GenreDTO gdto = new GenreDTO();
            for (GenreDTO genreDTO : arrGenre) {
                if(genreDTO.getId() == genre_id) {
                    gdto = genreDTO;
                    return genreDTO;
                }
            }
        }
        return null;
    }

}
