// You are given an array prices where prices[i] is the price of a given stock on the ith day, 
// and an integer fee representing a transaction fee.
// Find the maximum profit you can achieve. 
// You may complete as many transactions as you like, 
// but you need to pay the transaction fee for each transaction.
// Note: You may not engage in multiple transactions simultaneously 
// (i.e., you must sell the stock before you buy again).

// Pik0 = Profit after k transactions, with 0 stocks in hand
// Pik1 = Profit after k transactions, with 1 stock in hand

class Solution {
	// At each iteration we are checking if we should rest or buy (Pik0)
	// At each iteration we are checking if we should rest or sell(Pik1)
    public int maxProfit(int[] prices, int fee) {
        long Pik0 = 0;
        long Pik1 = Integer.MIN_VALUE;
        
        for(int price : prices) {
            long Pik0_old = Pik0;
            Pik0 = Math.max(Pik0, Pik1 + price - fee); // this line may underflow integer, so we take long
            Pik1 = Math.max(Pik1, Pik0_old - price);
        }
        
        return (int) Pik0;
    }
}
