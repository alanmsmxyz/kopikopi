/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kopikopi;

/**
 *
 * @author Byatriasa
 */
public interface DB {
    // Using remote database for easier testing process
    // To recreate the database schema in localhost, import kopikopi.sql
    static final String URL = "jdbc:mysql://103.134.152.1:3306/alanmsmx_kopikopi?serverTimezone=Asia/Jakarta";
    static final String USERNAME = "alanmsmx_kopikopi";
    static final String PASSWORD = "daYNGJ2m4bvQ";  
}
