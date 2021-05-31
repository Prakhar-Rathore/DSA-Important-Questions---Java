// Given an array of positive integers. 
// Find the maximum length of Bitonic subsequence. 
// A subsequence of array is called Bitonic if 
// it is first increasing, then decreasing.

class Solution {
	// Simple two way LIS problem
    public int LongestBitonicSequence(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];
        int[] lds = new int[n];
        for(int i = 0; i < n; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    if(lis[j] > max) {
                        max = lis[j];
                    }
                }
            }
            lis[i] = max + 1;
        }
        for(int i = n - 1; i >= 0; i--) {
            int max = 0;
            for(int j = n - 1; j > i; j--) {
                if(arr[i] > arr[j]) {
                    if(lds[j] > max) {
                        max = lds[j];
                    }
                }
            }
            lds[i] = max + 1;
        }
        int res = 0;
        for(int i = 0; i < n; i++) {
            res = Math.max(res, lds[i] + lis[i]);
        }
        return res - 1;
    }
}
