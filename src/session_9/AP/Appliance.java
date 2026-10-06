import java.util.Scanner;

abstract class Appliance {
    protected double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    public double calculateUnits() {
        return (getPower() * hours) / 1000;
    }

    public double calculateCost() {
        return calculateUnits() * 8;
    }
}

interface SaverMode {
    double calculateSaverUnits();
}

class Fridge extends Appliance {

    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }
}

class AC extends Appliance implements SaverMode {

    AC(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }
    public double calculateSaverUnits() {
        return calculateUnits() * 0.75;
    }
}

class TV extends Appliance {

    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }
}

class Washer extends Appliance implements SaverMode {

    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }

    public double calculateSaverUnits() {
        return calculateUnits() * 0.75;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double totalCost = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saverRequested = false;

            if (sc.hasNext("(?i)SAVER")) {
                sc.next();
                saverRequested = true;
            }

            Appliance appliance;

            if (type.equalsIgnoreCase("FRIDGE")) {

                appliance = new Fridge(hours);

            } else if (type.equalsIgnoreCase("AC")) {

                appliance = new AC(hours);

            } else if (type.equalsIgnoreCase("TV")) {

                appliance = new TV(hours);

            } else if (type.equalsIgnoreCase("WASHER")) {

                appliance = new Washer(hours);
            }

            if (saverRequested) {

                if (appliance instanceof SaverMode) {

                    SaverMode saver =
                        (SaverMode) appliance;

                    double units =
                        saver.calculateSaverUnits();

                    double cost = units * 8;

                    System.out.printf(
                        "%s: Units=%.2f Cost=%.2f%n",
                        type,
                        units,
                        cost
                    );

                    totalCost += cost;

                } else {

                    System.out.println(
                        type + ": saver mode not supported"
                    );
                }

            } else {

                double units =
                    appliance.calculateUnits();

                double cost =
                    appliance.calculateCost();

                System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    type,
                    units,
                    cost
                );

                totalCost += cost;
            }
        }

        System.out.printf(
            "Total Cost: %.2f%n",
            totalCost
        );

        sc.close();
    }
}