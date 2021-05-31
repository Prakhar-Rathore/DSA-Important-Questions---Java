// Given an array that is sorted and then rotated around an unknown point. 
// Find if the array has a pair with a given sum ‘x’. 
// It may be assumed that all elements in the array are distinct.

public class Solution {
	// Binary search to find pivot in O(logn) time.
	public static boolean findPairSum(int[] arr, int target) {
		int l = 0;
        int n = arr.length;
        int h = n - 1;
        int pivot = 0;
        while(l <= h) {
            int mid = l + (h - l) / 2;
            if(mid == n - 1 || arr[mid] > arr[mid + 1]) {
                pivot = mid;
                break;
            }
            else if(arr[mid] > arr[0]) {
                l = mid + 1;
            }
            else {
                h = mid - 1;
            }
        }
        l = pivot;
        h = (pivot + 1) % n;
        // Finding pair using two pointers approach and % n method 
        // to prevent index out of bounds.
        while(l != h) {
            if(arr[l] + arr[h] == target) {
                return true;
            }
            else if(arr[l] + arr[h] < target) {
                h = (h + 1) % n;
            }
            else {
                l = (n + l - 1) % n;
            }
        }
        return false;
	}
}
