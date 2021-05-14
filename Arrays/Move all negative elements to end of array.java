// Given an unsorted array having both negative and positive integers. 
// The task is place all negative element at the end of array, 
// without changing the order of positive element and negative element.

class Solution {
	// Very simple logic, just use an extra array and do the job.
    public void segregateElements(int arr[], int n) {
        int[] temp = new int[n];
        int j = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] > 0) {
                temp[j++] = arr[i];
            }
        }
        for(int i = 0; i < n; i++) {
            if(arr[i] <= 0) {
                temp[j++] = arr[i];
            }
        }
        for(int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }
}
