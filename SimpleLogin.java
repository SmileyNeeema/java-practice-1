import java.util.Scanner;

public class SimpleLogin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String correctUsername = "smileyNeema";
        String correctPassword = "01234";

        int attempts = 0;
        boolean loggedIn = false;

        while (attempts < 3 && !loggedIn) {
            System.out.print("Enter username: ");
            String username = sc.nextLine();

            System.out.print("Enter password: ");
            String password = sc.nextLine();

            // Simulate password masking by printing * (just for display)
            System.out.print("You entered password as: ");
            for (int i = 0; i < password.length(); i++) {
                System.out.print("*");
            }
            System.out.println();

            // Check credentials
            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                System.out.println("Login successful!");
                loggedIn = true;
            } else {
                attempts++;
                System.out.println("Incorrect username or password. Attempt " + attempts + " of 3.\n");
            }
        }

        if (!loggedIn) {
            System.out.println("Maximum attempts reached. Program exiting.");
        }

        sc.close();
    }
}
