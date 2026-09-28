package session_4.PP;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int lowestPrice = prices[0];
        int largestProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int currentProfit = prices[i] - lowestPrice;
            if (currentProfit > largestProfit) {
                largestProfit = currentProfit;
            }
            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            }
        }
        return largestProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}