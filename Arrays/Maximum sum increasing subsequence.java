// Given an array arr of N positive integers, 
// the task is to find the maximum sum increasing subsequence of the given array.

class Solution {
	// This problem is just a slight modification of
	// Longest Increasing Subsequence problem.
	public int maxSumIS(int arr[], int n) {
        int[] dp = new int[n];
        int res = 0;
        for(int i = 0; i < n; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    if(dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + arr[i];
            res = Math.max(res, dp[i]);
        }
        return res;
	}  
}
