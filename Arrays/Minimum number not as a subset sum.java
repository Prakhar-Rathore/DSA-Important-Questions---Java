// Given a sorted array of N positive integers, 
// find the smallest positive integer S such that 
// S cannot be represented as sum of elements of 
// any subset of the given array set.

class Solution {
	// Tricky stuff
    long findSmallest(long[] arr, int n) {
        long res = 1;
        for(int i = 0; i < n; i++) {
            if(arr[i] <= res) {
                res += arr[i];
            }
            else {
                break;
            }
        }
        return res;
    }
}
