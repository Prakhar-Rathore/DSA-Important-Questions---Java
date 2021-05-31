// Given an array of n positive integers and a number k. 
// Find the minimum number of swaps required to bring 
// all the numbers less than or equal to k together.

class Complete {
	// Trick is to use sliding window technique
    public static int minSwap (int arr[], int n, int k) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] <= k) {
                count++;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i <= n - count; i++) {
            int temp = 0;
            for(int j = i; j < i + count; j++) {
                if(arr[j] > k) {
                    temp++;
                }
            }
            res = Math.min(res, temp);
        }
        return res;
    }
}
