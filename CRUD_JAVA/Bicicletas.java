/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_5;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author oef63
 */
public class Bicicletas {
      public static Scanner sc = new Scanner(System.in);
    public static void ingresarBicicletas() throws SQLException{
        String sqlBici = "INSERT  INTO bicicletas VALUES (?, ?, ?, ?)" ;
        PreparedStatement senBici = principal.connect().prepareStatement(sqlBici);
        System.out.print("ID: ");
        int id = sc.nextInt();
        senBici.setInt(1, id);
        principal.sc.nextLine();
        
        System.out.print("Fabricante: ");
        String fabricante = sc.nextLine();
        senBici.setString(2, fabricante);
        
        System.out.print("Precio: ");
        int precio = sc.nextInt();
        senBici.setInt(3, precio );
        principal.sc.nextLine();
        
        System.out.print("email: ");
        String email = sc.nextLine();
        senBici.setString(4, email);
        
        int  filasIns = senBici.executeUpdate();
        if (filasIns > 0){
            System.out.println("exito");
        }
    
    }
}

