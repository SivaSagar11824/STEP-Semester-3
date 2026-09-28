package session_1.AP;

public class TrafficSignalStreakAnalyzer {
    public static void findLongestStreak(String signalLog) {
        char longestColor = signalLog.charAt(0);
        int longestLength = 1;
        int currentLength = 1;
        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                currentLength++;
            } else {
                currentLength = 1;
            }
            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestColor = signalLog.charAt(i);
            }
        }
        System.out.printf("Longest Streak: '%c' repeated %d times%n", longestColor, longestLength);
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
    }
}
