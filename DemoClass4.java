import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DemoClass4
 */
/**
 * DemoClass4
 */
public class DemoClass4 {

    static String url = "jdbc:mysql://localhost:3306/people";
    static String user = "root";
    static String password = "@8VDBHZ12724";
    static String query = "INSERT INTO person (roll,name) VALUES (?,?)";


  public static void main(String[] args) {
    DemoClass4 demoClass4 = new DemoClass4();
    demoClass4.addBatch();
     
    }
    void addBatch(){
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url,user,password);
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1,7);
            statement.setString(2,"King");
            statement.addBatch();

            statement.setInt(1, 8);
            statement.setString(2, "James");
            statement.addBatch();

            statement.setInt(1, 9);
            statement.setString(2, "United");
            statement.addBatch();

            statement.setInt(1, 10);
            statement.setString(2, "America");
            statement.addBatch();

            // statement.clearBatch();

            int [] res = statement.executeBatch();

           for (int i : res) {
            System.out.println(i);
           }

           ResultSet resultSet = statement.executeQuery("SELECT * FROM person");
           while (resultSet.next()) {
            System.out.println("roll: "+resultSet.getInt("roll")+ " name: "+resultSet.getString("name"));
           }

            resultSet.close();
            con.close();
            statement.close();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}