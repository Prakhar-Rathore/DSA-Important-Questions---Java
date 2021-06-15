// Given an array nums[] of size n, 
// construct a Product Array P (of same size n) 
// such that P[i] is equal to the product of all the elements of nums except nums[i].

// Using left and right to solve the problem, without using division operator.
class Solution {
	public static long[] productExceptSelf(int arr[], int n) {
        long[] left = new long[n];
        long[] right = new long[n];
        left[0] = arr[0];
        for(int i = 1; i < n; i++) {
            left[i] = left[i - 1] * arr[i];
        }
        right[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * arr[i];
        }
        long[] res = new long[n];
        Arrays.fill(res, 1);
        for(int i = 0; i < n; i++) {
            if(i > 0) {
                res[i] *= left[i - 1];
            }
            if(i < n - 1) {
                res[i] *= right[i + 1];
            }
        }
        return res;
	} 
} 
