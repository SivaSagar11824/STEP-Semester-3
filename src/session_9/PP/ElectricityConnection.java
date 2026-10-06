import java.util.Scanner;

abstract class ElectricityConnection {
    protected int units;

    ElectricityConnection(int units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class Home extends ElectricityConnection {

    Home(int units) {
        super(units);
    }

    double calculateBill() {

        if (units <= 100) {
            return units * 5;
        }
        else {
            return (100 * 5) + ((units - 100) * 7);
        }
    }
}

class Shop extends ElectricityConnection {

    Shop(int units) {
        super(units);
    }

    double calculateBill() {
        return (units * 8) + 100;
    }
}

class Factory extends ElectricityConnection {

    Factory(int units) {
        super(units);
    }

    double calculateBill() {

        double bill = units * 6;

        if (bill < 1000) {
            bill = 1000;
        }

        return bill;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int units = sc.nextInt();

            ElectricityConnection connection;

            if (type.equalsIgnoreCase("HOME")) {

                connection = new Home(units);

            } else if (type.equalsIgnoreCase("SHOP")) {

                connection = new Shop(units);

            } else if (type.equalsIgnoreCase("FACTORY")) {

                connection = new Factory(units);
            }

            double bill = connection.calculateBill();

            System.out.printf(
                "%s: %.2f%n",
                type,
                bill
            );

            total += bill;
        }

        System.out.printf(
            "Total: %.2f%n",
            total
        );

        sc.close();
    }
}