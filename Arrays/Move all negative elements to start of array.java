// An array contains both positive and negative numbers in random order. 
// Rearrange the array elements so that all negative numbers appear before all positive numbers. 
// Order of elements is not important here.

class Solution {
	// This is the basic quick sort partitioning process.
    public void segregateElements(int arr[], int n) {
        int j = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] < 0) {
                swap(arr, i, j);
                j++;
            }
        }
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
