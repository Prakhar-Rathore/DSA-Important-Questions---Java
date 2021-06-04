// Given an array A[] of N positive integers. 
// The task is to find the maximum of j - i 
// subjected to the constraint of A[i] <= A[j].

class Solution {
	// Idea is to make left and right array.
    static int maxIndexDiff(int arr[], int n) { 
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = arr[0];
        for(int i = 1; i < n; i++) {
            left[i] = Math.min(arr[i], left[i - 1]);
        }
        right[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i + 1]);
        }
        int i = 0;
        int j = 0;
        int res = Integer.MIN_VALUE;
        while(i < n && j < n) {
            if(left[i] <= right[j]) {
                res = Math.max(res, j - i);
                j++;
            }
            else {
                i++;
            }
        }
        return res;
    }
}
