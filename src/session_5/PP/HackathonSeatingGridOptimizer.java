public class HackathonSeatingGridOptimizer {
    private static double rowAverage(int[] row) {
        int total = 0;
        for (int i = 0; i < row.length; i++) {
            total = total + row[i];
        }
        return (double) total / row.length;
    }

    public static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            double average = rowAverage(seatingScores[i]);
            result.append("Row ").append(i).append(": ");

            if (average < threshold) {
                result.append("Quiet Zone");
            } else {
                result.append("Buzzing Zone");
            }

            if (i < seatingScores.length - 1) {
                result.append(" | ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[][] scores = {{40, 50, 45}, {85, 90, 95}, {30, 20, 25}};
        System.out.println(classifyRows(scores, 60));
    }
}