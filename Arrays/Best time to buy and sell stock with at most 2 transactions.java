// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// Find the maximum profit you can achieve. 
// You may complete at most two transactions.
// Note: You may not engage in multiple transactions simultaneously 
// (i.e., you must sell the stock before you buy again).

// Case 1 - Time O(n) and space O(n)
class Solution {
	// This approach is only going to work for this specific problem
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] left = new int[n];
        int min = prices[0];
        int profit = 0;
        for(int i = 1; i < n; i++) {
            min = Math.min(min, prices[i]);
            profit = prices[i] - min;
            left[i] = Math.max(profit, left[i - 1]);
        }
        
        int[] right = new int[n];
        int max = prices[n - 1];
        profit = 0;
        for(int i = n - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            profit = max - prices[i];
            right[i] = Math.max(profit, right[i + 1]);
        }
        
        int res = 0;
        for(int i = 0; i < n; i++) {
            res = Math.max(res, left[i] + right[i]);
        }
        return res;
    }
}

// Time O(n) and space O(1)
class Solution {
	// Simple recurrence relations idea
    public int maxProfit(int[] prices) {
        int Pi10 = 0;
        int Pi11 = Integer.MIN_VALUE;
        int Pi20 = 0;
        int Pi21 = Integer.MIN_VALUE;
        
        for(int price : prices) {
            Pi20 = Math.max(Pi20, Pi21 + price);
            Pi21 = Math.max(Pi21, Pi10 - price);
            Pi10 = Math.max(Pi10, Pi11 + price);
            Pi11 = Math.max(Pi11, -price);
        }
        
        return Pi20;
    }
}
