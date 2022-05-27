/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paths;

/**
 *
 * @author Manh Hai
 */
public class Path {
    private static String pathUser = "C:\\Users\\admin\\Documents\\NetBeansProjects\\Library_Management_System (1)\\src\\Books_image";
    private static String pathBook = "";

    public static String getPathUser() {
        return pathUser;
    }

    public static void setPathUser(String pathUser) {
        Path.pathUser = pathUser;
    }

    public static String getPathBook() {
        return pathBook;
    }

    public static void setPathBook(String pathBook) {
        Path.pathBook = pathBook;
    }

    
}
