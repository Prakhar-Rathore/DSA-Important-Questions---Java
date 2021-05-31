// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// Find the maximum profit you can achieve. 
// You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

class Solution {
	// We buy at every dip and sell at every high.
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int buy = 0;
        int sell = 0;
        int res = 0;
        for(int i = 1; i < n; i++) {
            if(arr[i] > arr[i - 1]) {
                sell++;
            }
            else {
                res += arr[sell] - arr[buy];
                sell = buy = i;
            }
        }
        res += arr[sell] - arr[buy]; // to make sure if the high was the last element, it is also counted.
        return res;
    }
}

// A slight variation of this question is to return the indices of the buy and sell days, here it becomes a little
// tricky, because now, buy == sell never cancel out and are counted, so we have to include them only if
// arr[sell] > arr[buy]. Closely look at the else loop here.

class Solution {
    ArrayList<ArrayList<Integer>> stockBuySell(int arr[], int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int buy = 0;
        int sell = 0;
        for(int i = 1; i < n; i++) {
            if(arr[i] > arr[i - 1]) {
                sell++;
            }
            else {
                if(arr[buy] < arr[sell]) { // the one condition i was talking about.
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(buy);
                    temp.add(sell);
                    res.add(temp);
                }
                buy = sell = i;
            }
        }
        if(arr[buy] < arr[sell]) { // the one condition i was talking about.
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(buy);
            temp.add(sell);
            res.add(temp);
        }
        return res;
    }
}
