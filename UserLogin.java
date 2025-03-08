import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserLogin {
    public static boolean login(String username, String password) {
        try {
            Connection con = DBConnection.connect();
            String query = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("✅ Login Successful, Welcome " + username);
                return true;
            } else {
                System.out.println("❌ Invalid Credentials");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
 public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Username: ");
        String username = scanner.next();
        System.out.print("Enter Password: ");
        String password = scanner.next();
        login(username, password);
        scanner.close();
    }
}
