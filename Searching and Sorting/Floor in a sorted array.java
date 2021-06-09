// Given a sorted array arr[] of size N without duplicates, 
// and given a value x. 
// Floor of x is defined as the largest element K in arr[] such that 
// K is smaller than or equal to x. 
// Find the index of K(0-based indexing).

// The idea is to use binary search.
class Solution {
    static int findFloor(long arr[], int n, long x) {
        int l = 0;
        int h = n - 1;
        while(l <= h) {
            int mid = l + (h - l) / 2;
            if(arr[mid] == x) {
                return mid;
            }
            else if(arr[mid] > x) {
                h = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return h;
    }
}

