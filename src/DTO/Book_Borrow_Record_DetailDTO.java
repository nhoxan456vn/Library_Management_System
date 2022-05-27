/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Manh Hai
 */
public class Book_Borrow_Record_DetailDTO {
    private int br_detail_id;
    private int br_id;
    private int book_id;
    private String status;

    public Book_Borrow_Record_DetailDTO() {
    }

    public Book_Borrow_Record_DetailDTO(int br_detail_id, int br_id, int book_id, String status) {
        this.br_detail_id = br_detail_id;
        this.br_id = br_id;
        this.book_id = book_id;
        this.status = status;
    }

    public int getBr_detail_id() {
        return br_detail_id;
    }

    public void setBr_detail_id(int br_detail_id) {
        this.br_detail_id = br_detail_id;
    }

    public int getBr_id() {
        return br_id;
    }

    public void setBr_id(int br_id) {
        this.br_id = br_id;
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
}
