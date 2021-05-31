// Given an array of size n and a range [a, b]. 
// The task is to partition the array around the range such that array is divided into three parts.
// 1) All elements smaller than a come first.
// 2) All elements in range a to b come next.
// 3) All elements greater than b appear in the end.
// The individual elements of three sets can appear in any order. 
// You are required to return the modified array.

class Solution {
	// Slight variation of the Dutch National Flag problem.
    public void threeWayPartition(int arr[], int a, int b) {
        int n = arr.length;
        int i = 0;
        int j = 0;
        int k = n - 1;
        while(j <= k) {
            if(arr[j] >= a && arr[j] <= b) {
                j++;
            }
            else if(arr[j] < a) {
                swap(arr, i, j);
                i++;
                j++;
            }
            else {
                swap(arr, j, k);
                k--;
            }
        }
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
