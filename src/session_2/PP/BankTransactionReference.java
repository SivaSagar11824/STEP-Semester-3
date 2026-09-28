package session_2.PP;

public class BankTransactionReference {
    public static String normalizeReference(String raw) {
        String reference = raw.trim();
        if (reference.length() >= 3) {
            reference = reference.substring(0, 3).toUpperCase() + reference.substring(3);
        }
        return reference;
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must be 14 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < reference.length(); i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: reference body must contain only digits";
            }
        }

        StringBuilder result = new StringBuilder();
        result.append("[").append(reference.substring(0, 3)).append("] DATE: ");
        result.append(reference.substring(3, 5)).append("/");
        result.append(reference.substring(5, 7)).append("/");
        result.append(reference.substring(7, 9)).append(" | SEQ: ");
        result.append(reference.substring(9));
        return result.toString();
    }

    public static void main(String[] args) {
        String reference = normalizeReference(" hdf03022600042 ");
        System.out.println(validateAndFormat(reference));
    }
}