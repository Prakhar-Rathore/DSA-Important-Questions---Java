// Given a sorted and rotated array A of N distinct elements which is rotated at some point, 
// and given an element key. The task is to find the index of the given element key in the array A.

class Solution {
	// Modified binary search
    int search(int arr[], int l, int h, int x) {
        while(l <= h) {
            int mid = l + (h - l) / 2;
            if(arr[mid] == x) {
                return mid;
            }
            if(arr[mid] > arr[l]) {
                if(arr[l] <= x && x < arr[mid]) {
                    h = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
            else {
                if(arr[mid] < x && x <= arr[h]) {
                    l = mid + 1;
                }
                else {
                    h = mid - 1;
                }
            }
        }
        return -1;
    }
}
