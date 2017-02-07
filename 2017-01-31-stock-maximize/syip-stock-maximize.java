package stockmaximize;
/**
 * @author syip
 * Your algorithms have become so good at predicting the market that you now 
 * know what the share price of Wooden Orange Toothpicks Inc. (WOT) will be 
 * for the next N days.

 * Each day, you can either buy one share of WOT, sell any number of shares of 
 * WOT that you own, or not make any transaction at all. What is the maximum 
 * profit you can obtain with an optimum trading strategy?
 * 
 * Solution: Find highest price and calculate profit up until that point, 
 * repeat for entire array O(n)
 */
public class StockMaximize {   
    public static int maxProfit(int[] prices) {
        if (prices == null) return 0;
        int start = 0;
        int tail = prices.length-1;
        int totalProfit = 0;
        while (start < tail) {
            int highestPriceIndex = highestPriceIndex(prices, start);
            totalProfit += getProfitInRange(prices, start, highestPriceIndex);
            start = highestPriceIndex+1;
        }
        return totalProfit;
    }
    
    public static int getProfitInRange(int[]prices, int startIndex, int highestPriceIndex) {
        int total = 0;
        int highestPrice = prices[highestPriceIndex];
        for (int i = startIndex; i < highestPriceIndex; i++) {
            total += highestPrice - prices[i];
        }
        return total;
    }
    
    public static int highestPriceIndex(int[] prices, int lowBound) {
        int highestPrice = prices[lowBound];
        int highestPriceIndex = lowBound;
        for (int i = lowBound+1; i < prices.length; i++) {
            if (prices[i] >= highestPrice) {
                highestPrice = prices[i];
                highestPriceIndex = i;
            }
        }
        return highestPriceIndex;
    }

    public static void main(String[] args) {
        assert maxProfit(new int[] {7,6,5,4,3,2})==0;
        assert maxProfit(new int[] {7,6,5,4,3,4})==1;
        assert maxProfit(new int[] {1,2,3,4,5,6})==15; 
        assert maxProfit(new int[] {7,3,3,4,5,6})==9;
        assert maxProfit(new int[] {7,7,7,7,7,7})==0;
    } 
}
