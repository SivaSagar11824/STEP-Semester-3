package session_2.AP;

public class ProductInventoryCsvParser {
    public static void parseInventoryRecord(String csvLine) {
        String[] details = csvLine.split(",");

        if (details.length == 3) {
            System.out.println("Product: " + details[0] + " | SKU: " + details[1]
                    + " | Qty: " + details[2]);
        } else {
            System.out.println("Invalid Record");
        }
    }

    public static void main(String[] args) {
        parseInventoryRecord("Wireless Mouse,WM-2201,150");
    }
}