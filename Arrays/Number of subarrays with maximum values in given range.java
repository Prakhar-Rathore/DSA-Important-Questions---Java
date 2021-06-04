// Given an array of N elements and L and R, 
// print the number of sub-arrays such that the value of the //
// maximum array element in that subarray is at least L and at most R.

// The question can be divided into three parts
// >=l and <=r kings
// >r villains
// <l common people

// kings will build subarray on their own
// common people can only help kings build subarray
// villains break the subarray and will force next king to
// build a subarray.
class Solution {
    static long countSubarrays(int arr[], int n, int l, int r) {
        int start = 0;
        long res = 0;
        int length = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] >= l && arr[i] <= r) {
                length = i - start + 1; // kings
            }
            else if(arr[i] > r) {
                start = i + 1; // villains
                length = 0;
            }
            res += length; // subarray lengths added
        }
        return res;
    }
}
