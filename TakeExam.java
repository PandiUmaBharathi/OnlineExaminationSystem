import java.sql.*;
import java.util.Scanner;

public class TakeExam {
    public static void startExam(String username) {
        try {
            Connection con = DBConnection.connect();
            Scanner scanner = new Scanner(System.in);
            int score = 0;
            
            // Fetch all questions
            String query = "SELECT * FROM questions";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println("\nQ: " + rs.getString("question_text"));
                System.out.println("A) " + rs.getString("option_a"));
                System.out.println("B) " + rs.getString("option_b"));
                System.out.println("C) " + rs.getString("option_c"));
                System.out.println("D) " + rs.getString("option_d"));
                System.out.print("Your answer: ");
                
                String userAnswer = scanner.next().toUpperCase();
                if (userAnswer.equals(rs.getString("correct_option"))) {
                    score++;
                }
            }

            // Store result in the database
            String insertQuery = "INSERT INTO results (user_id, score) VALUES ((SELECT user_id FROM users WHERE username=?), ?)";
            PreparedStatement insertPst = con.prepareStatement(insertQuery);
            insertPst.setString(1, username);
            insertPst.setInt(2, score);
            insertPst.executeUpdate();

            System.out.println("\n✅ Exam completed! Your score: " + score);
            scanner.close();
        } catch (Exception e) {
            System.out.println("❌ Error: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.next();
        startExam(username);
        scanner.close();
    }
}
