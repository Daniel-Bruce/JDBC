
/*
* Steps to connect to database;
* 1)Import package --> java.sql
* 2)Load and register the driver -->com.mysql.jdbc.driver
* 3)Establish the connection -->Connection con
* 4)Create statement --> Statement, PrepareStatement, CallableStatement
* 5)Execute query -->
* 6)Process the result
* 7)close
* */


import java.sql.*;

public class DemoClass {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/people";
        String user = "root";
        String password = "@8VDBHZ12724";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url,user,password);
            Statement statement = con.createStatement();
            String query = "SELECT * FROM person";
            ResultSet rs = statement.executeQuery(query);
            rs.next();

            System.out.println("roll:"+ rs.getInt(1));
            System.out.print("Name:"+rs.getString(2));

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
