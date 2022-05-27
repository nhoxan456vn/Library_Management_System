/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.BookDAO;
import DTO.BookDTO;
import My_Functions.Func_Class;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author Manh Hai
 */
public class BookBUS {
    private static ArrayList<BookDTO> arrBook = new ArrayList<>();
    private BookDAO bookDAO = new BookDAO();
    
    My_Functions.Func_Class func = new Func_Class();

    public BookBUS() {
        arrBook = bookDAO.readDB();
    }
    
    public void readDB(){
        arrBook = bookDAO.readDB();
    }
    
    public Boolean add(BookDTO book){
        Boolean check = bookDAO.add(book);
        if (check){
            arrBook.add(book);
        }
        return check;
    }
    
    public Boolean del(int id){
        Boolean check = bookDAO.del(id);
        if (check){
            for (BookDTO book : arrBook){
                if (book.getBook_id() == id){
                    arrBook.remove(book);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean del(String isbn){
        Boolean check = bookDAO.del(isbn);
        if (check){
            for (BookDTO book : arrBook){
                if (book.getIsbn().equalsIgnoreCase(isbn)){
                    arrBook.remove(book);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean upd(BookDTO book){
        Boolean check = bookDAO.upd(book);  
        if (check){
            for (BookDTO b : arrBook){
                if (b.getIsbn()== book.getIsbn()){
                    arrBook.set(arrBook.indexOf(b), book);
                    break;
                }
            }
        } 
        return check;
    }
    
    public ArrayList<BookDTO> getArrBook() {
        readDB();
        return arrBook;
    }
    
    public int getArrSize(){
        return arrBook.size();
    }

    public boolean checkISBNexists(String isbn) {
        return bookDAO.hasISBN(isbn);
    }

    public BookDTO getBookByID(int book_id) {
        if(bookDAO.hasBookID(book_id)) {
            BookDTO bdto = new BookDTO();
            for (BookDTO bookDTO : arrBook) {
                if(bookDTO.getBook_id() == book_id) {
                    bdto = bookDTO;
                    return bdto;
                }
            }
        }
        return null;
    }
    
     // function to populate an arrayList with books by
    public ArrayList<BookDTO> bookListByName(String value) {
        return bookDAO.bookListByName(value);
    }

    public ArrayList<BookDTO> bookListByDate(String dateFrom, String dateTo) {
        return bookDAO.bookListByDate(dateFrom, dateTo);
    }
    
    // create the function to display the lastest 5 books
    public void displayBooksCover(JLabel[] lables_tab) {
            String picture;
            String myPath = "C:\\Users\\Manh Hai\\Documents\\NetBeansProjects\\Library_Management_System\\src\\Books_image";
            for(int i=0; i<=4; i++) {
                picture = myPath + "\\" + arrBook.get(i).getPicture();
                func.displayImageByPath(lables_tab[i].getWidth(), lables_tab[i].getHeight(), picture, lables_tab[i]);
            }
    }
    
    public BookDTO searchBookByISBN(String _isbn) {
        for (BookDTO bookDTO : arrBook) {
            if(bookDTO.getIsbn().equalsIgnoreCase(_isbn)) {
                return bookDTO;
            }
        }
        return null;
    }
    
}
