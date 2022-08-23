/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_5;

import static com.mycompany.reto_5.Bicicletas.sc;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Motocicletas {
    public static void ingresarMotocicletas() throws SQLException{
        String sqlBici = "INSERT  INTO bicicletas VALUES (?, ?, ?, ?)" ;
        PreparedStatement senMoto = principal.connect().prepareStatement(sqlBici);
        System.out.print("ID: ");
        int id = sc.nextInt();
        senMoto.setInt(1, id);
        principal.sc.nextLine();
        
        System.out.print("Fabricante: ");
        String fabricante = sc.nextLine();
        senMoto.setString(2, fabricante);
        
        System.out.print("Precio: ");
        int precio = sc.nextInt();
        senMoto.setInt(3, precio );
        principal.sc.nextLine();
        
        System.out.print("Precio: ");
        int autonomia = sc.nextInt();
        senMoto.setInt(3, autonomia );
        principal.sc.nextLine();
        
      
        
        
        int  filasIns = senMoto.executeUpdate();
        if (filasIns > 0){
            System.out.println("exito");
        }
   }
}