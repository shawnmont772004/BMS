package Bank.Management.System;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;

public class Conn {
    Connection connection;
    Statement statement1,statement2;
    public Conn(){
       try{
           connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/bms","root","shanon6122006s");
           System.out.println("Database connected");
           statement1 = connection.createStatement();
           statement2 = connection.createStatement();
       }
       catch(Exception ex)
       {
            ex.printStackTrace();
       }

    }

    public static void main(String[] args) {

    }

}
