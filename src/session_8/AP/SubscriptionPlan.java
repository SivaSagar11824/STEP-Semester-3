import java.time.LocalDate;
import java.util.Scanner;

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;

    SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int getValidityDays();

    public LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends SubscriptionPlan {

    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends SubscriptionPlan {

    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends SubscriptionPlan {

    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    int getValidityDays() {
        return 365;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            LocalDate startDate =
                LocalDate.parse(date);

            SubscriptionPlan plan;

            if (type.equals("BASIC")) {

                plan = new BasicPlan(
                    name,
                    startDate
                );

            } else if (type.equals("STANDARD")) {

                plan = new StandardPlan(
                    name,
                    startDate
                );

            } else {

                plan = new PremiumPlan(
                    name,
                    startDate
                );
            }

            LocalDate renewalDate =
                plan.getRenewalDate();

            System.out.println(
                name + ": " + renewalDate
            );
        }

        sc.close();
    }
}