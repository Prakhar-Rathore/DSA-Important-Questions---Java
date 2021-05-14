//Given a binary array A[] of size N. The task is to arrange the array in increasing order.
//Note: The binary array contains only 0  and 1.

//Sol 1 - Using binary search two pointer approach.
class Solution {
	// Maintain two pointers l and h
	// If 1, element in correct region, just increase h.
	// If 0, element in wrong region, needs to go to l region, so swap, and increase l, and increase h, because l
	// only contains 1, so no need to check for this h again.
    static void binSort(int arr[], int n) {
        int l = 0;
        int h = 0;
        while(h < n) {
            if(arr[h] == 1) {
                h++;
            }
            else {
                swap(arr, h, l);
                h++;
                l++;
            }
        }
    }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


//Using naive approach (count total 1 and 0 and just iterate over the array again)

class Solution {
	// Just count the total 0 and 1 and then replace in the array.
    static void binSort(int arr[], int n) {
        int count0 = 0;
        int count1 = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == 0){
                count0++;
            }
            else {
                count1++;
            }
        }
        for(int i = 0; i < count0; i++){
            
            arr[i] = 0;
            
        }
        for(int i = count0; i < n; i++){
            
            arr[i] = 1;
            
        }
    }
}
