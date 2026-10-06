import java.util.Scanner;

abstract class Ticket {
    protected int count;

    protected static final double CONVENIENCE_FEE = 20;

    Ticket(int count) {
        this.count = count;
    }

    abstract double getPrice();

    public double calculateAmount() {
        return count * (getPrice() + CONVENIENCE_FEE);
    }
}

class Regular extends Ticket {

    Regular(int count) {
        super(count);
    }

    double getPrice() {
        return 150;
    }
}

class Premium extends Ticket {

    Premium(int count) {
        super(count);
    }

    double getPrice() {
        return 250;
    }
}

class Recliner extends Ticket {

    Recliner(int count) {
        super(count);
    }

    double getPrice() {
        return 400;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String seat = sc.next();
            int count = sc.nextInt();

            Ticket ticket;

            if (seat.equalsIgnoreCase("REGULAR")) {

                ticket = new Regular(count);

            } else if (seat.equalsIgnoreCase("PREMIUM")) {

                ticket = new Premium(count);

            } else if (seat.equalsIgnoreCase("RECLINER")) {

                ticket = new Recliner(count);
            }

            double amount = ticket.calculateAmount();

            System.out.printf(
                "%s: %.2f%n",
                seat,
                amount
            );

            total += amount;
        }

        System.out.printf(
            "Total: %.2f%n",
            total
        );

        sc.close();
    }
}