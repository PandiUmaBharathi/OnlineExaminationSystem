import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ViewResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.next();
        
        try {
            Connection con = DBConnection.connect();
            String query = "SELECT score, exam_date FROM results r INNER JOIN users u ON r.user_id = u.user_id WHERE u.username = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            
            System.out.println("\n📊 Exam Results for " + username + ":");
            System.out.println("-------------------------------------");
            boolean hasResults = false;
            while (rs.next()) {
                hasResults = true;
                System.out.println("🗓 Date: " + rs.getTimestamp("exam_date") + " | 🏆 Score: " + rs.getInt("score"));
            }
            
            if (!hasResults) {
                System.out.println("❌ No exam records found.");
            }

        } catch (Exception e) {
            System.out.println("❌ Error fetching results: " + e);
        }
        
        scanner.close();
    }
}
