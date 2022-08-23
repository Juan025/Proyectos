
package com.mycompany.reto_5;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Consultas {
    public static void crearTablas(){
          try{
            String[]  sqls = {
                "CREATE TABLE proveedor (prov_id int primary key,prov_nombre char(20),prov_direccion char(45), prov_telefono char(20))",
                "CREATE TABLE clientes (alias char(20) primary key, nombre char(20), email varchar(45), telefono char (20), contraseña int)",
                "CREATE TABLE fabricantes (fabricante char(20) primary key)",
                "CREATE TABLE bicicletas (id int primary key, fabricante char(20), precio int, año int, foreign key (fabricante) references fabricantes (fabricante))",
                "CREATE TABLE motocicletas ( id int primary key,fabricante char (20),precio int,autonomia int,id_prov int, foreign key (fabricante) references fabricantes (fabricante),foreign key (id_prov) references proveedor (prov_id))",
                "CREATE TABLE compras ( id int primary key,alias char(20), fabricante char(20),fecha_hora timestamp, foreign key (alias) references clientes (alias), foreign key (fabricante) references fabricantes (fabricante))"
            };
            for (String i:sqls){
                 PreparedStatement senten = principal.connect().prepareStatement(i);
                 senten.executeUpdate();
            }
          }catch(SQLException e){
              System.out.println("tablas ya creadas");
          }
          
          
    }
    public static void ModificaAño() throws SQLException{
        String sqlm = "UPDATE bicicletas SET año=? WHERE fabricante=?";
        PreparedStatement sentenncia = principal.connect().prepareStatement(sqlm);
        System.out.println("ingrese el fabricante y año a modificar");
        System.out.println("Fabricante: ");
        String nombre = principal.sc.nextLine();
        sentenncia.setString(2, nombre);
        
        System.out.print("Año: ");
        int year = principal.sc.nextInt();  
        sentenncia.setInt(1, year);
        principal.sc.nextLine();
        int  filasIns = sentenncia.executeUpdate();
        if (filasIns > 0){
            System.out.println("Ejecutado con exito");

      }
    }
    public static void ModificaTelCliente()throws SQLException{
        String sqlm = "UPDATE clientes SET celular=? WHERE alias=?";
        PreparedStatement sentenncia = principal.connect().prepareStatement(sqlm);
        System.out.println("ingrese el alais y telefono a modificar");
        System.out.println("Alias: ");
        String alias = principal.sc.nextLine();
        sentenncia.setString(2, alias);
        
        System.out.print("Telefono: ");
        int telefono = principal.sc.nextInt();  
        sentenncia.setInt(1, telefono);
        principal.sc.nextLine();
        int  filasIns = sentenncia.executeUpdate();
        if (filasIns > 0){
            System.out.println("Ejecutado con exito");}
    }
     public static void BorraCompra()throws SQLException{
        String sqlm = "DELETE FROM compras WHERE alias=? AND fabricante=?";
        PreparedStatement sentenncia = principal.connect().prepareStatement(sqlm);
        System.out.println("ingrese el alias y el fabricante");
        System.out.println("Alias: ");
        String alias = principal.sc.nextLine();
        sentenncia.setString(1, alias);
        
        System.out.print("Fabricante: ");
        String fab = principal.sc.nextLine();
        sentenncia.setString(2, fab);
        
        int  filasIns = sentenncia.executeUpdate();
        if (filasIns > 0){
            System.out.println("Eliminado con exito");
            }
        }
     public static void ConsultaFabricante() throws SQLException{
         String sql = "SELECT fabricante FROM fabricantes ORDER BY fabricante";
         Statement sentenncia = principal.connect().createStatement();
         ResultSet consulta = sentenncia.executeQuery(sql);
         
         while (consulta.next()){
             String col1 = consulta.getNString(1);
             System.out.println(col1);
         
         }
         
     }
      public static void ConsultaInfoBici() throws SQLException{
         String sql = "SELECT fabricante,precio,año FROM bicicletas WHERE año >= 2019 ORDER BY fabricante";
         Statement sentenncia = principal.connect().createStatement();
         ResultSet consulta = sentenncia.executeQuery(sql);
         
         while (consulta.next()){
             String colm1 = consulta.getNString(1);
             int col2 = consulta.getInt(2);
             String col3 = consulta.getNString(3);
             
             System.out.println(colm1+" "+col2+" "+col3);
             
         
         }
      }
      public static void ConsultaFabriMoto() throws SQLException{
         String sql = "select fabricante from motocicletas where id_prov=101";
         Statement sentenncia = principal.connect().createStatement();
         ResultSet consulta = sentenncia.executeQuery(sql);
         
         while (consulta.next()){
             String colm1 = consulta.getNString(1);
             System.out.println(colm1);
         }
      }
      
      public static void ConsultaCompBiMo() throws SQLException{
         String sql = "select fabricante from compras where alias=\'lucky\' order by fabricante";
         Statement sentenncia = principal.connect().createStatement();
         ResultSet consulta = sentenncia.executeQuery(sql);
         
         while (consulta.next()){
             String colm1 = consulta.getNString(1);
             System.out.println(colm1);
          }
      }
      
       public static void ConsultaCompBici() throws SQLException{
         String sql = "select c.alias, c.nombre, c.apellido from clientes c, compras p where p.alias=c.alias and p.fabricante=\'Yeti\' order by nombre";
         Statement sentenncia = principal.connect().createStatement();
         ResultSet consulta = sentenncia.executeQuery(sql);
         
         while (consulta.next()){
             String colm1 = consulta.getNString(1);
             String colm2 = consulta.getNString(2);
             String colm3 = consulta.getNString(3);
             System.out.println(colm1+" "+colm2+" "+colm3);
          }
      }
       public static void consultaBiciFab() throws SQLException{
         System.out.println("ingrese el año: ");
         System.out.println("Año: ");
         int year = principal.sc.nextInt();
         principal.sc.nextLine();
         String sql = "select count(fabricante) from bicicletas where año >= " + year;
         Statement sentenncia = principal.connect().createStatement();
         ResultSet consulta = sentenncia.executeQuery(sql);
         
         while (consulta.next()){
            int colm1 = consulta.getInt(1);
            System.out.println(colm1);
          }
      }

} 