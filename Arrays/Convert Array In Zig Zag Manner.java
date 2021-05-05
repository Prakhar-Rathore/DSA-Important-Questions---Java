//Given an array Arr (distinct elements) of size N. 
//Rearrange the elements of array in zig-zag fashion. 
//The converted array should be in form a < b > c < d > e < f. 
//The relative order of elements is same in the output i.e you have to iterate on the original array only.

//Normal logic is to swap elements when they are not in the zig zag manner.

class Solution {
    void zigZag(int arr[], int n) {
        for(int i = 0; i < n - 1; i++) {
            if(i % 2 == 0) {
                if(arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            else {
                if(arr[i] < arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }
}
