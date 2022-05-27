/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Manh Hai
 */
public class Book_Borrow_RecordDTO {
    private int id;
    private int librarian_id;
    private int member_id;
    private String borrowDate;
    private String termDate;
    private int totalQuantity;

    public Book_Borrow_RecordDTO() {
    }

    public Book_Borrow_RecordDTO(int id, int librarian_id, int member_id, String borrowDate, String termDate, int totalQuantity) {
        this.id = id;
        this.librarian_id = librarian_id;
        this.member_id = member_id;
        this.borrowDate = borrowDate;
        this.termDate = termDate;
        this.totalQuantity = totalQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLibrarian_id() {
        return librarian_id;
    }

    public void setLibrarian_id(int librarian_id) {
        this.librarian_id = librarian_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getTermDate() {
        return termDate;
    }

    public void setTermDate(String termDate) {
        this.termDate = termDate;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
      
}
