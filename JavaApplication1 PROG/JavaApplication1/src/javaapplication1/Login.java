package javaapplication1;

public class Login {

    private String storedUsername;
    private String storedPassword;
    private String firstName;
    private String lastName;

    // Store all the user details
    public void setUserDetails(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.storedUsername = username;
        this.storedPassword = password;
    }

    // The username validation
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // The pasword validation
    public boolean checkPasswordComplexity(String password) {
        boolean length = password.length() >= 8;
        boolean capital = password.matches(".*[A-Z].*");
        boolean number = password.matches(".*\\d.*");
        boolean special = password.matches(".*[^a-zA-Z0-9].*");

        return length && capital && number && special;
    }

    // The Cell phone validation (regex)
    public boolean checkCellPhoneNumber(String phone) {
        // SA number format: +27 followed by 9 digits
        return phone.matches("^\\+27\\d{9}$");
    }

    // To Register the user
    public String registerUser(String username, String password, String phone) {

        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber(phone)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        return "User successfully registered.";
    }

    //  the Login validation
    public boolean loginUser(String username, String password) {
        return username.equals(storedUsername) && password.equals(storedPassword);
    }

    // The return login message
    public String returnLoginStatus(boolean status) {
        if (status) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";//KWENA
        }
    }
}