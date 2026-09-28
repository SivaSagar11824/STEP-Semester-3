public class PalindromeChecker {
    public static boolean isPalindromeIterative(String text) {
        int last = text.length() - 1;
        for (int i = 0; i < text.length() / 2; i++) {
            if (text.charAt(i) != text.charAt(last - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        return text.equals(new String(reversed));
    }

    public static void printResult(String approach, boolean result) {
        if (result) {
            System.out.println(approach + ": Palindrome");
        } else {
            System.out.println(approach + ": Not Palindrome");
        }
    }

    public static void main(String[] args) {
        String text = "madam";
        printResult("Iterative", isPalindromeIterative(text));
        printResult("Recursive", isPalindromeRecursive(text));
        printResult("Array Reversal", isPalindromeArrayReversal(text));
    }
}