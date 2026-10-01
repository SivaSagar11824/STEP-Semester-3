package session_7.PP;

public class Locker {
    private String code;
    private final int lockerNumber;

    Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public void changeCode(String currentCode, String newCode) {

        if (code.equals(currentCode)) {
            code = newCode;
            System.out.println("Code changed successfully.");
        } else {
            System.out.println("Code change rejected.");
        }
    }

    public int getLockerNumber() {
        return lockerNumber;
    }
}

public class Main {
    public static void main(String[] args) {

        Locker l = new Locker(101, "1234");

        System.out.println("Locker Number: " + l.getLockerNumber());

        l.changeCode("1234", "5678");

        l.changeCode("0000", "9999");
    }
}