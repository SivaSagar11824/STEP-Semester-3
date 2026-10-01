package session_7.AP;

public class PasswordChecker {
    private final String password;

    PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int length = password.length();

        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}

public class Main {
    public static void main(String[] args) {

        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("Password 1 strength: " + pc1.getStrength());

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println("Password 2 strength: " + pc2.getStrength());

        PasswordChecker pc3 = new PasswordChecker("abcdefghijkl");
        System.out.println("Password 3 strength: " + pc3.getStrength());
    }
}