// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// You want to maximize your profit by choosing a single day 
// to buy one stock and choosing a different day in the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. 
// If you cannot achieve any profit, return 0.

class Solution {
	// we try to find the max profit at each iteration (profit if sold today), and we store the minimum price of stock
	// at every iteration, doing this guarantees that at one point the maximum profit will
	// be achieved.
    public int maxProfit(int[] prices) {
        int buy_price = prices[0];
        int res = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > buy_price) {
                res = Math.max(res, prices[i] - buy_price);
            }
            else {
                buy_price = prices[i];
            }
        }
        return res;
    }
}
// Pi10 = Profit if the stock is sold today.
// Pi11 = Profit if the stock is bought today.
class Solution {
	// Recurrence relations 
    public int maxProfit(int[] prices) {
        int Pi10 = 0;
        int Pi11 = Integer.MIN_VALUE;
        
        for(int price : prices) {
            Pi10 = Math.max(Pi10, Pi11 + price);
            Pi11 = Math.max(Pi11, -price);
        }
        
        return Pi10;
    }
}
