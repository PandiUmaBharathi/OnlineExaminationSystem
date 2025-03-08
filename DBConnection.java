import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection connect() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_exam", "root", "umabharathi@12345");
            System.out.println("✅ Database connected successfully!");
        } catch (Exception e) {
            System.out.println("❌ Database connection failed: " + e);
        }
        return con;
    }
}
