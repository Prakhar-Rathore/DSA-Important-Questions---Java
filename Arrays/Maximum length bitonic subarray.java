// Given an array Arr[0 … N-1] containing N positive integers, 
// a subarray Arr[i … j] is bitonic if there is a k with 
// i <= k <= j such that A[i] <= Arr[i+1] <= ... <= Arr[k] >= Arr[k+1] >= ... A[j – 1] >= A[j]. 
// Write a function that takes an array and array length as arguments and 
// returns the length of the maximum length bitonic subarray.
// For Example: In array {20, 4, 1, 2, 3, 4, 2, 10} the maximum 
// length bitonic subarray is {1, 2, 3, 4, 2} which is of length 5.

class Solution {
    int bitonic(int[] arr, int n) {
        int res = 1;
        int i = 0;
        int start_next = 0;
        int start = 0;
        while(i < n - 1) {
            while(i < n - 1 && arr[i] <= arr[i + 1]) {
                i++;
            }
            while(i < n - 1 && arr[i] >= arr[i + 1]) {
                if(i < n - 1 && arr[i] > arr[i + 1]) {
                    start_next = i + 1;
                }
                i++;
            }
            res = Math.max(res, i - start + 1);
            start = start_next;
        }
        return res;
    }

}
