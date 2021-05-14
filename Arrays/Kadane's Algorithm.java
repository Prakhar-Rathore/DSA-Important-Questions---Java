// Given an array arr of N integers. 
// Find the contiguous sub-array with maximum sum.

class Solution {
	// Very basic problem of dynamic programming
    int maxSubarraySum(int arr[], int n) {
        int sum = arr[0];
        int res = arr[0];
        for(int i = 1; i < n; i++) {
            if(sum >= 0) {
                sum += arr[i];
            }
            else {
                sum = arr[i];
            }
            res = Math.max(sum, res);
        }
        return res;
    }
}
