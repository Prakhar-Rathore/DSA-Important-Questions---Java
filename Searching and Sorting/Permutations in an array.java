// Given two arrays of equal size N and an integer K. 
// The task is to check if after permuting both arrays, 
// we get sum of their corresponding element greater than or equal to k 
// i.e Ai + Bi >= K for all i (from 0 to N-1). 
// Return true if possible, else false.

class Solution {
    public boolean isPossible(long arr[], long brr[], long n, long k) {
        Arrays.sort(arr);
        Arrays.sort(brr);
        reverse(brr, n);
        for(int i = 0; i < n; i++) {
            if(!(arr[i] + brr[i] >= k)) {
                return false;
            }
        }
        return true;
    }
    public void reverse(long[] arr, long n) {
        int l = 0;
        int h = (int) n - 1;
        while(l < h) {
            long temp = arr[l];
            arr[l] = arr[h];
            arr[h] = temp;
            l++;
            h--;
        }
    }
}
