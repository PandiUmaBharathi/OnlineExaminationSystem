import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Username: ");
        String username = sc.next();
        System.out.print("Enter Password: ");
        String password = sc.next();

        if (UserLogin.login(username, password)) {
            System.out.println("Access Granted ✅");
        } else {
            System.out.println("Access Denied ❌");
        }
    }
}
