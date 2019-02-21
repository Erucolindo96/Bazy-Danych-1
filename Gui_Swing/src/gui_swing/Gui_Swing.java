/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_swing;
import database_connection.DataBaseConnection;
import database_connection.*;
import java.sql.*;
import gui_package.*;
/**
 *
 * @author erucolindo
 */
public class Gui_Swing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        MainWindow wind = new MainWindow();
        wind.setVisible(true);
        //try
        //{    
        //Connection c = DataBaseConnection.openConnection(); 
        /*
        try{
            Connection c = DataBaseConnection.openConnection(); 
            Statement stm = c.createStatement();
            
            ResultSet restuls = stm.executeQuery("SELECT * FROM mydb.Adres");//QueryExecution.executeQuery("SELECT * FROM mydb.Adres");
            while(restuls.next())
            {
                System.out.println(restuls.getInt("idAdres"));
            }
            stm.close();
        }
        catch(SQLException e)
        {
            System.err.println("Coś się popsuło");
        }
        DataBaseConnection.closeConnection();
        //}
        //catch(SQLException exp)
        //{
          //  System.out.println("Lol, nie polaczyles sie z baza");
        //}
        */
    }
    
}
