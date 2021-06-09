// Given an array arr[] of distinct integers of size N and a sum value X, 
// the task is to find count of triplets with the sum smaller than the given sum value X.


// Using two pointer approach
class Solution {
    long countTriplets(long arr[], int n, int sum) {
        Arrays.sort(arr);
        long count = 0;
        for(int i = 0; i < n; i++) {
            int l = i + 1;
            int h = n - 1;
            long a = arr[i];
            while(l <= h) {
                if(arr[l] + arr[h] + a >= sum) {
                    h--;
                }
                else {
                    count += (h - l);
                    l++;
                }
            }
        }
        return count;
    }
}
