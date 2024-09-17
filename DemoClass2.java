import java.sql.*;

public class DemoClass2 {
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
            while (rs.next()){
                System.out.println("Roll:"+ rs.getInt(1)+ " Name:"+rs.getString(2));
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
}
}

