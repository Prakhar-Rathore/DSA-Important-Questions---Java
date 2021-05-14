// Given an array arr[] of N positive integers. 
// Push all the zero’s of the given array to the right end of the array while maitaining the order of non-zero elements.

class Solution {
	// We maintain two pointers and will swap them if the element is not zero
	// The i pointer will keep on increasing and eventually reach the point where there
	// are some zeroes behind it, now if we swap then the zeroes will be slowly pushed
	// towards the end. This method will maintain the relative order of the elements.
    void pushZerosToEnd(int[] arr, int n) {
        int i = 0;
        int j = 0;
        for(i = 0; i < n; i++) {
            if(arr[i] > 0) {
                swap(arr, i, j);
                j++;
            }
        }
    }
    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
