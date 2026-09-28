public class ReverseCustomerName {
    public static String reverseCustomerName(String customerName) {
        String reversedName = "";
        for (int i = customerName.length() - 1; i >= 0; i--) {
            reversedName = reversedName + customerName.charAt(i);
        }
        return reversedName;
    }

    public static void main(String[] args) {
        String customerName = "Sunil";
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reverseCustomerName(customerName));
    }
}