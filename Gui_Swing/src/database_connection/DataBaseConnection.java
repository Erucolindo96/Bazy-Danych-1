/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_connection;
import java.sql.*;
import java.util.Properties;
/**
 *
 * @author erucolindo
 */
public class DataBaseConnection {
    
    
    private static final String database_name = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "root";
    private static final String password = "szynka1!";
    private static final String FULL_URL = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=utf8&autoReconnect=true&user=root&password=szynka1!";
    private static Connection opened_connection;
    private static Statement opened_statement;
    private static boolean isOpenConnection = false ;
    private static boolean isOpenStatement = false;
    
    public static Connection openConnection() 
    {
       if(!isOpenConnection)
       {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //opened_connection = DriverManager.getConnection(database_name, user, password);
            opened_connection = DriverManager.getConnection(FULL_URL);
            isOpenConnection = true;
        }
        catch(ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e)
        {
            System.err.println("Błąd połączenia z bazą danych");
            e.printStackTrace();
            System.out.println(e);
        }
       } 
       
       return opened_connection;
    }
    public static void closeConnection() 
    {
        
        if(isOpenConnection)
        {    
            try 
            {
                opened_connection.close();
                isOpenConnection = false;
            } 
            catch (SQLException e) 
            {
                System.out.println("Blad przy zamykaniu polaczenia " +e.toString());
            }
        }
        
        
    }
     
    public static Statement getStatementInstance() throws SQLException
    {
        if(!isOpenStatement)
        {
            Connection con = DataBaseConnection.openConnection();
            opened_statement = con.createStatement();
            isOpenStatement = true;
        }
            return opened_statement;   
    }
    public static void closeStatement()throws SQLException
    {
        if(isOpenStatement)
        {
            opened_statement.close();
            isOpenStatement = false;
        }
    }
    
    
}
