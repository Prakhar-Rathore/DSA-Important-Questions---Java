// Given an array and a number k, 
// find the largest sum of the subarray containing at least k numbers. 
// It may be assumed that the size of array is at-least k.

class Compute {
	// Variation of the very popular kadane's algorithm.
    public long maxSumWithK(long arr[], long n, long k) {
        long[] kadane = new long[(int)n];
        kadane[0] = arr[0];
        long sum = arr[0];
        for(int i = 1; i < n; i++) {
            if(sum >= 0) {
                sum += arr[i];
            }
            else {
                sum = arr[i];
            }
            kadane[i] = sum;
        }
        sum = 0;
        for(int i = 0; i < k; i++) {
            sum += arr[i];
        }
        long res = sum;
        for(int i = (int) k; i < n; i++) {
            sum += (arr[i] - arr[i - (int) k]);
            if(kadane[i - (int) k] > 0) {
                res = Math.max(res, sum + kadane[i - (int) k]);
            }
            else {
                res = Math.max(res, sum);
            }
        }
        return res;
    }
}
