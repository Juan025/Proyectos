/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_5;

import static com.mycompany.reto_5.Clientes.sc;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Compras {
    public static void ingresarCompras()throws SQLException{
        
        String sqlcomp = "INSERT  INTO compras VALUES (?, ?, ?, ?)" ;
        PreparedStatement sentencia = principal.connect().prepareStatement(sqlcomp);
        System.out.print("Id: ");
        int id = sc.nextInt();
        sentencia.setInt(1, id);
        principal.sc.nextLine();
        
        System.out.print("Alias Comprador: ");
        String alias = sc.nextLine();
        sentencia.setString(2, alias);
        
        System.out.print("Fabricante: ");
        String fabricante = sc.nextLine();
        sentencia.setString(3, fabricante);
        
        System.out.print("Feacha y Hora: ");
        String time = sc.nextLine();
        sentencia.setString(4, time);
    }
}
