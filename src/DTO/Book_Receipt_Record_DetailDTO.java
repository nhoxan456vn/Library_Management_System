/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Manh Hai
 */
public class Book_Receipt_Record_DetailDTO {
    private int receipt_detail_id;
    private int receipt_id;
    private int book_id;
    private int unitPrice;
    private int quantity;
    private int amount;

    public Book_Receipt_Record_DetailDTO() {
    }

    public Book_Receipt_Record_DetailDTO(int receipt_detail_id, int receipt_id, int book_id, int unitPrice, int quantity, int amount) {
        this.receipt_detail_id = receipt_detail_id;
        this.receipt_id = receipt_id;
        this.book_id = book_id;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.amount = amount;
    }

    public int getReceipt_detail_id() {
        return receipt_detail_id;
    }

    public void setReceipt_detail_id(int receipt_detail_id) {
        this.receipt_detail_id = receipt_detail_id;
    }

    public int getReceipt_id() {
        return receipt_id;
    }

    public void setReceipt_id(int receipt_id) {
        this.receipt_id = receipt_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
}
