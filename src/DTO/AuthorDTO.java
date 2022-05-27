/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Manh Hai
 */
public class AuthorDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String expertise;
    private String about;

    public AuthorDTO() {
    }

    public AuthorDTO(int id, String firstName, String lastName, String expertise, String about) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.expertise = expertise;
        this.about = about;
    }

    public AuthorDTO(String firstName, String lastName, String expertise, String about) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.expertise = expertise;
        this.about = about;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
