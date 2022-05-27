/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Manh Hai
 */
public class Book_Receipt_RecordDTO {
    private int receipt_id;
    private int librarian_id;
    private int supplier_id;
    private String date;
    private int totalQuantity;
    private int totalMoney;

    public Book_Receipt_RecordDTO() {
    }

    public Book_Receipt_RecordDTO(int receipt_id, int librarian_id, int supplier_id, String date, int totalQuantity, int totalMoney) {
        this.receipt_id = receipt_id;
        this.librarian_id = librarian_id;
        this.supplier_id = supplier_id;
        this.date = date;
        this.totalQuantity = totalQuantity;
        this.totalMoney = totalMoney;
    }

    public int getReceipt_id() {
        return receipt_id;
    }

    public void setReceipt_id(int receipt_id) {
        this.receipt_id = receipt_id;
    }

    public int getLibrarian_id() {
        return librarian_id;
    }

    public void setLibrarian_id(int librarian_id) {
        this.librarian_id = librarian_id;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }
}
