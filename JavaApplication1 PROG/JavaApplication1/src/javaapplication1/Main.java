package javaapplication1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        System.out.println("===== USER REGISTRATION =====");

        System.out.print("Please enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Please enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Please enter Username:(Must contain a _) ");
        String username = scanner.nextLine();

        System.out.print("Please enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Please enter SA Cell Number (+27...): ");
        String cellPhone = scanner.nextLine();

        // the user registry
        String registerMessage = login.registerUser(username, password, cellPhone);
        System.out.println(registerMessage);

        // Store the user details if their are correct
        if (registerMessage.contains("successfully")) {
            login.setUserDetails(firstName, lastName, username, password);

            System.out.println("\n===== LOGIN =====");

            System.out.print("Enter Username: ");
            String loginUser = scanner.nextLine();

            System.out.print("Enter Password: ");
            String loginPass = scanner.nextLine();

            boolean loginStatus = login.loginUser(loginUser, loginPass);
            System.out.println(login.returnLoginStatus(loginStatus));
        }
//RNR
        scanner.close();
    }
}