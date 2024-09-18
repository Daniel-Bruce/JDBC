import java.sql.*;

public class DemoClass3 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/people";
        String user = "root";
        String password = "@8VDBHZ12724";
        String query = "DELETE FROM person WHERE name = 'name'";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url,user,password);
            PreparedStatement statement = con.prepareStatement(query);
            int rs = statement.executeUpdate();

            System.out.print("rows affected count:" + rs);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
