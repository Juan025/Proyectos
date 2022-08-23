/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_5;

import static com.mycompany.reto_5.Clientes.sc;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author oef63
 */
public class Proveedor {
    public static void ingresarProveedor() throws SQLException{
        String sqlprov = "INSERT  INTO proveedor VALUES (?, ?, ?, ?)" ;
        PreparedStatement sentencia = principal.connect().prepareStatement(sqlprov);
        System.out.print("ID: ");
        int id = sc.nextInt();
        sentencia.setInt(1, id);
        principal.sc.nextLine();
        
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        sentencia.setString(2, nombre);
         
        
        System.out.print("Direccion: ");
        String direccion = sc.nextLine();
        sentencia.setString(3,direccion );
        
        
        System.out.print("Telefono: ");
        String telefono = sc.nextLine();
        sentencia.setString(4, telefono);
        
      
        
        int  filasIns = sentencia.executeUpdate();
        if (filasIns > 0){
            System.out.println("Ejecutado con exito");
        }
    
   
     }
    
    
}
    
 

  