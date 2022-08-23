/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_5;

import static com.mycompany.reto_5.Bicicletas.sc;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class fabricantes {
    public static void ingresarFabricantes() throws SQLException{
        String sqlFab = "INSERT  INTO fabricantes VALUES (?)" ;
        PreparedStatement senFab = principal.connect().prepareStatement(sqlFab);
        
        System.out.print("Nombre Fabricante: ");
        String fabricante = sc.nextLine();
        senFab.setString(1, fabricante);
        
        
        int  filasIns = senFab.executeUpdate();
        if (filasIns > 0){
            System.out.println("exito");
        }
   }
}
