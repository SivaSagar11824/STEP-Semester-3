import java.util.Scanner;

abstract class Student {
    protected String name;

    protected static final double TRANSPORT_FEE = 12000;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateTuition();

    public boolean usesBus() {
        return false;
    }

    public double calculateTotalFee() {

        double fee = calculateTuition();

        if (usesBus()) {
            fee = fee + TRANSPORT_FEE;
        }

        return fee;
    }
}

class DayScholar extends Student {

    DayScholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000;
    }

    public boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {

    Hosteller(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000 + 60000;
    }
}

class Scholar extends Student {

    Scholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return 20000;
    }

    public boolean usesBus() {
        return true;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double totalCollected = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            Student student;

            if (type.equalsIgnoreCase("DAY_SCHOLAR")) {

                student = new DayScholar(name);

            } else if (type.equalsIgnoreCase("HOSTELLER")) {

                student = new Hosteller(name);

            } else if (type.equalsIgnoreCase("SCHOLAR")) {

                student = new Scholar(name);
            }

            double fee = student.calculateTotalFee();

            System.out.printf(
                "%s: %.2f%n",
                student.name,
                fee
            );

            totalCollected += fee;
        }

        System.out.printf(
            "Total Collected: %.2f%n",
            totalCollected
        );

        sc.close();
    }
}