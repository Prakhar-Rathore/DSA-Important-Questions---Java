//Given an array arr[] of N integers arranged in a circular fashion.
//Your task is to find the maximum contiguous subarray sum.

class Solution {
    static int circularSubarraySum(int a[], int n) {
    	// two possible cases 
    	// 1 - normal kadane is the maximum sum (without overlapping)
    	// 2 - overlapped sum is the maximum sum
    	// to perform the case 2 we use an approach called reverseKadane
    	// Here we find the minimum sum subarray and then subtract this sum from the total sum.
    	// This gives the case 2 sum
    	// We return the maximum sum
    	// the reverse Kadane is important algorithm
    	// reverse each element off array and then find the kadane. 
    	// subtract this from the total sum which will then give the sum of overlapped kadane
    	// if the kadane of the array is negative, then overlapped one will be even more negative, so just return this value.
        if(kadane(a, n) < 0) {
            return kadane(a, n);
        }
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += a[i];
        }
        return Math.max(kadane(a,n), sum + reverseKadane(a,n));
    }
    
    static int kadane(int[] arr, int n) {
        int sum = arr[0];
        int res = arr[0];
        for(int i = 1; i < n; i++) {
            if(sum < 0) {
                sum = arr[i];
            }
            else {
                sum += arr[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
    static int reverseKadane(int[] arr, int n) {
        for(int i = 0; i < n; i++) {
            arr[i] *= -1;
        }
        int sum = arr[0];
        int res = arr[0];
        for(int i = 1; i < n; i++) {
            if(sum < 0) {
                sum = arr[i];
            }
            else {
                sum += arr[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}

