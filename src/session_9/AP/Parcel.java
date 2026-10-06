import java.util.Scanner;

abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();

    public double calculateInsurance() {
        return 0;
    }

    public double calculateTotal() {
        return calculateCharge() + calculateInsurance();
    }
}

interface Insurable {
    double calculateInsurance();
}

class StandardParcel extends Parcel {

    StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 40 + (10 * weight);
    }
}

class ExpressParcel extends Parcel implements Insurable {

    ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 80 + (15 * weight);
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {

    FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 40 + (10 * weight) + 50;
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double grandTotal = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();

            Parcel parcel;

            if (type.equalsIgnoreCase("STANDARD")) {

                parcel = new StandardParcel(
                    weight,
                    declaredValue
                );

            } else if (type.equalsIgnoreCase("EXPRESS")) {

                parcel = new ExpressParcel(
                    weight,
                    declaredValue
                );

            } else if (type.equalsIgnoreCase("FRAGILE")) {

                parcel = new FragileParcel(
                    weight,
                    declaredValue
                );
            }

            double charge = parcel.calculateCharge();
            double insurance = parcel.calculateInsurance();
            double total = parcel.calculateTotal();

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type,
                charge,
                insurance,
                total
            );

            grandTotal += total;
        }

        System.out.printf(
            "Grand Total: %.2f%n",
            grandTotal
        );

        sc.close();
    }
}