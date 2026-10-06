import java.util.Scanner;

abstract class Cab {
    protected double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    public double calculateFare() {

        double fare = km * getRate();

        if (fare < 100) {
            fare = 100;
        }

        return fare;
    }
}

interface NightService {
    double applyNightCharge(double fare);
}

class Mini extends Cab {

    Mini(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }
}

class Sedan extends Cab implements NightService {

    Sedan(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }

    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

class SUV extends Cab implements NightService {

    SUV(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }

    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            if (type.equalsIgnoreCase("MINI")) {

                cab = new Mini(km);

            } else if (type.equalsIgnoreCase("SEDAN")) {

                cab = new Sedan(km);

            } else if (type.equalsIgnoreCase("SUV")) {

                cab = new SUV(km);
            }

            if (time.equalsIgnoreCase("NIGHT")) {

                if (cab instanceof NightService) {

                    double fare = cab.calculateFare();

                    NightService nightCab =
                        (NightService) cab;

                    fare = nightCab.applyNightCharge(fare);

                    System.out.printf(
                        "%s: %.2f%n",
                        type,
                        fare
                    );

                    total += fare;

                } else {

                    System.out.println(
                        type + ": night service not available"
                    );
                }

            } else {

                double fare = cab.calculateFare();

                System.out.printf(
                    "%s: %.2f%n",
                    type,
                    fare
                );

                total += fare;
            }
        }

        System.out.printf(
            "Total: %.2f%n",
            total
        );

        sc.close();
    }
}