import java.util.*;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i. Design an algorithm to find the maximum profit. You may complete at most k transactions. Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

public class stock_selling_k_transaction {
    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int k, int[] prices) {
        if (k<= 0 || prices == null || prices.length == 0) {
            return 0;
        }
        
        int n = prices.length;
        
        int[][] local = new int[n][k+1];
        int[][] global = new int[n][k+1];
        
        for (int i = 1; i < n; ++i) {
            int diff = prices[i] - prices[i-1];
            
            for (int j = 1; j <= k; ++j) {
                local[i][j] = Math.max(local[i-1][j] + diff, global[i-1][j-1] + Math.max(0, diff));
                
                // Today has transaction vs no transaction
                global[i][j] = Math.max(local[i][j], global[i-1][j]);
            }
        }
        
        return global[n-1][k];
    }
}
