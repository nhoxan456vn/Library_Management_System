/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Manh Hai
 */
public class Book_Return_RecordDTO {
    private int rt_id;
    private int br_id;
    private int member_id;
    private int librarian_id;
    private int totalQuantity;

    public Book_Return_RecordDTO() {
    }

    public Book_Return_RecordDTO(int rt_id, int br_id, int member_id, int librarian_id, int totalQuantity) {
        this.rt_id = rt_id;
        this.br_id = br_id;
        this.member_id = member_id;
        this.librarian_id = librarian_id;
        this.totalQuantity = totalQuantity;
    }

    public int getRt_id() {
        return rt_id;
    }

    public void setRt_id(int rt_id) {
        this.rt_id = rt_id;
    }

    public int getBr_id() {
        return br_id;
    }

    public void setBr_id(int br_id) {
        this.br_id = br_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public int getLibrarian_id() {
        return librarian_id;
    }

    public void setLibrarian_id(int librarian_id) {
        this.librarian_id = librarian_id;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
