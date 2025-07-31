package learning.DP;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 * <p>
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
     int [] prices= {7,6,4,3,1};
        System.out.println(maxProfit(prices));

    }

    public static int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int maxProfit= 0;
        for (int i=1;i<prices.length;i++){
            maxProfit = Math.max(prices[i]-buyPrice, maxProfit);
            if(buyPrice> prices[i])
                buyPrice =prices[i];
        }
        return maxProfit;
    }


    public int maxProfitBrutForce(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int buyPrice = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > buyPrice && maxProfit < (prices[j] - buyPrice))
                    maxProfit = prices[j] - buyPrice;

            }
        }
        return maxProfit;
    }
}
