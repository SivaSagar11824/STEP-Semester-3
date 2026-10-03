import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int getLoanPeriod();

    public LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(getLoanPeriod());
    }

    public String getTitle() {
        return title;
    }
}

class Book extends LibraryItem {

    Book(String title) {
        super(title);
    }

    @Override
    int getLoanPeriod() {
        return 14;
    }
}

class DVD extends LibraryItem {

    DVD(String title) {
        super(title);
    }

    @Override
    int getLoanPeriod() {
        return 7;
    }
}

class Magazine extends LibraryItem {

    Magazine(String title) {
        super(title);
    }

    @Override
    int getLoanPeriod() {
        return 3;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        LocalDate currentDate =
                LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            // Find the first space
            int space = line.indexOf(' ');

            // Get item type
            String type = line.substring(0, space);

            // Get title
            String title = line.substring(space + 1);

            // Remove quotation marks
            title = title.replace("\"", "");

            LibraryItem item;

            if (type.equals("BOOK")) {

                item = new Book(title);

            } else if (type.equals("DVD")) {

                item = new DVD(title);

            } else {

                item = new Magazine(title);
            }

            LocalDate dueDate =
                    item.getDueDate(currentDate);

            System.out.println(
                    item.getTitle() + ": " + dueDate
            );
        }

        sc.close();
    }
}