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
public class Clientes {
    public static Scanner sc = new Scanner(System.in);
    public static void ingresarClientes() throws SQLException{
        String sql = "INSERT  INTO clientes VALUES (?, ?, ?, ?, ?, ?)" ;
        PreparedStatement sentencia = principal.connect().prepareStatement(sql);
        System.out.print("Alias: ");
        String alias = sc.nextLine();
        sentencia.setString(1, alias);
        
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        sentencia.setString(2, nombre);
        
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        sentencia.setString(3,apellido );
        
        System.out.print("email: ");
        String email = sc.nextLine();
        sentencia.setString(4, email);
        
        System.out.print("Telefono: ");
        String telefono = sc.nextLine();
        sentencia.setString(5, telefono);
        
        System.out.print("Contraseña: ");
        int contraseña = sc.nextInt();
        sentencia.setInt(6, contraseña);
        
        int  filasIns = sentencia.executeUpdate();
        if (filasIns > 0){
            System.out.println("Ejecutado con exito");
        }
    
    }
}
