//Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.

class Solution {
	// Using the same approach, only difference is the three regions
	// If 1, element in correct region, just increase i
	// If 2, element in wrong region, needs to go to k region, so swap, and decrease k
	// If 0, element in wrong region, needs to go to j region, so swap, and increase j, and increase i, because j
	// only contains 1, so no need to check for this i again.
    public static void sort012(int arr[], int n) {
        int i = 0;
        int j = 0;
        int k = n - 1;
        while(i <= k) {
            if(arr[i] == 1) {
                i++;
            }
            else if(arr[i] == 0) {
                swap(arr, i, j);
                i++;
                j++;
            }
            else {
                swap(arr, i, k);
                k--;
            }
        }
    }
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
