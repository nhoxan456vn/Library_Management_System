/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Manh Hai
 */
public class Book_Return_Record_DetailDTO {
    private int rt_detail_id;
    private int rt_id;
    private int book_id;
    private String status;
    private String termDate;
    private String returnDate;
    private int fine;

    public Book_Return_Record_DetailDTO() {
    }

    public Book_Return_Record_DetailDTO(int rt_detail_id, int rt_id, int book_id, String status, String termDate, String returnDate, int fine) {
        this.rt_detail_id = rt_detail_id;
        this.rt_id = rt_id;
        this.book_id = book_id;
        this.status = status;
        this.termDate = termDate;
        this.returnDate = returnDate;
        this.fine = fine;
    }

    public int getRt_detail_id() {
        return rt_detail_id;
    }

    public void setRt_detail_id(int rt_detail_id) {
        this.rt_detail_id = rt_detail_id;
    }

    public int getRt_id() {
        return rt_id;
    }

    public void setRt_id(int rt_id) {
        this.rt_id = rt_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTermDate() {
        return termDate;
    }

    public void setTermDate(String termDate) {
        this.termDate = termDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }
}
