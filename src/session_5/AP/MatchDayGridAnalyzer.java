package session_5.AP;

public class MatchDayGridAnalyzer {
    private static double rowAverage(int[] row) {
        int total = 0;
        for (int i = 0; i < row.length; i++) {
            total = total + row[i];
        }
        return (double) total / row.length;
    }

    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double average = rowAverage(runsPerOver[i]);
            result.append("Match ").append(i).append(": ");

            if (average >= threshold) {
                result.append("Power Surge");
            } else {
                result.append("Normal");
            }

            if (i < runsPerOver.length - 1) {
                result.append(" | ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[][] runs = {{4, 6, 8}, {10, 12, 14}, {2, 3, 1}};
        System.out.println(classifyMatches(runs, 8));
    }
}