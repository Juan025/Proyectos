
package com.mycompany.reto_5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class principal {
    public static Scanner sc =new Scanner(System.in);
         
    public static void main(String[] args){
        menu();
    }
    
    public static void menu(){
        try{
            System.out.println("""
                               ***************
                               ***  CRUD  ***
                               ***************
                               1. Crear Tablas.
                               ------------------------------------------------------------------
                               2. Ingresar datos tabla proveedor.
                               3. ingresar datos tabla Clientes.
                               4. ingresar datos tabla Fabricantes.
                               5. ingresar datos tabla Bicicletas.
                               6. ingresar datos tabla Motocicletas.
                               7. ingresar datos tabla Compras.
                               -------------------------------------------------------------------
                               8. modificar A\u00f1o de Bicicleta.
                               9. modificar Telefono cliente.
                               10. borrar intencion de Compra.
                               -------------------------------------------------------------------
                               11. listado de fabricantes.
                               12. mostrar informacion fabricantes de biciletas desde 2019
                               13. mostrar informacion motocicletasd con motor auteco.
                               14. mostrar fabricante intencion de compra cliente *Lucky*.
                               15. mostrar clientes que quieren comprar bicicleta marca Yeti.
                               16. Cantidad de bicicletas fabricadas desde "x" A\u00f1o.
                               -------------------------------------------------------------------
                               -- otro numero para SALIR --
                               -------------------------------------------------------------------
                               """);
            System.out.println(">> ");
            String input = sc.nextLine();
            byte opcion = Byte.parseByte(input);
            switch (opcion){
                case 1 -> Consultas.crearTablas();
                case 2 -> Proveedor.ingresarProveedor();
                case 3 -> Clientes.ingresarClientes();
                case 4 -> fabricantes.ingresarFabricantes();
                case 5 -> Bicicletas.ingresarBicicletas();
                case 6 -> Motocicletas.ingresarMotocicletas();
                case 7 -> Compras.ingresarCompras();
                case 8 -> Consultas.ModificaAño();
                case 9 -> Consultas.ModificaTelCliente();
                case 10 -> Consultas.BorraCompra();
                case 11 -> Consultas.ConsultaFabricante();
                case 12 -> Consultas.ConsultaInfoBici();
                case 13 -> Consultas.ConsultaFabriMoto();
                case 14 -> Consultas.ConsultaCompBiMo();
                case 15 -> Consultas.ConsultaCompBici();   
                case 16 -> Consultas.consultaBiciFab();
                default -> System.out.println("hasta pronto...");
                
                
            }
            
                                  
        }
        catch(Exception e){
            System.out.println("hasta pronto...");
        }
        
    }
    
    public static Connection connect(){
        String dbURL = "jdbc:mysql://127.0.0.1:3306/reto_4";
        String user = "root";
        String password = "";
        Connection con = null;
        
        try{
            con = DriverManager.getConnection(dbURL, user, password);
            if(con != null){
                System.out.println("* Conectado *");
            }
        }catch(SQLException error){
            System.out.println("Error: " + error.getErrorCode() + " " + error.getMessage());
        
        }
        return con;
    }

    
}
