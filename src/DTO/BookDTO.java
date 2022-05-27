/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Manh Hai
 */
public class BookDTO {
    private int book_id;
    private String name;
    private String isbn;
    private int genre_id;
    private int author_id;
    private String publisher;
    private double price;
    private String date_received;
    private String description;
    private int totalQuantity;
    private int borrowQuantity;
    private String picture;

    public BookDTO() {
    }

    public BookDTO(int book_id, String name, String isbn, int genre_id, int author_id, String publisher, double price, String date_received, String description, int totalQuantity, int borrowQuantity, String picture) {
        this.book_id = book_id;
        this.name = name;
        this.isbn = isbn;
        this.genre_id = genre_id;
        this.author_id = author_id;
        this.publisher = publisher;
        this.price = price;
        this.date_received = date_received;
        this.description = description;
        this.totalQuantity = totalQuantity;
        this.borrowQuantity = borrowQuantity;
        this.picture = picture;
    }

    public BookDTO(String name, String isbn, int genre_id, int author_id, String publisher, double price, String date_received, String description, int totalQuantity, int borrowQuantity, String picture) {
        this.name = name;
        this.isbn = isbn;
        this.genre_id = genre_id;
        this.author_id = author_id;
        this.publisher = publisher;
        this.price = price;
        this.date_received = date_received;
        this.description = description;
        this.totalQuantity = totalQuantity;
        this.borrowQuantity = borrowQuantity;
        this.picture = picture;
    }

    public BookDTO(int book_id, String name, String isbn, int genre_id, int author_id, String publisher, double price, String date_received, String description, int totalQuantity, String picture) {
        this.book_id = book_id;
        this.name = name;
        this.isbn = isbn;
        this.genre_id = genre_id;
        this.author_id = author_id;
        this.publisher = publisher;
        this.price = price;
        this.date_received = date_received;
        this.description = description;
        this.totalQuantity = totalQuantity;
        this.picture = picture;
    }

    public BookDTO(String name, String isbn, int genre_id, int author_id, String publisher, double price, String date_received, String description, int totalQuantity, String picture) {
        this.name = name;
        this.isbn = isbn;
        this.genre_id = genre_id;
        this.author_id = author_id;
        this.publisher = publisher;
        this.price = price;
        this.date_received = date_received;
        this.description = description;
        this.totalQuantity = totalQuantity;
        this.picture = picture;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate_received() {
        return date_received;
    }

    public void setDate_received(String date_received) {
        this.date_received = date_received;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getBorrowQuantity() {
        return borrowQuantity;
    }

    public void setBorrowQuantity(int borrowQuantity) {
        this.borrowQuantity = borrowQuantity;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    
}
