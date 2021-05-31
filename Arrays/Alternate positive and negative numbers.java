// Given an unsorted array Arr of N positive and negative numbers. 
// Your task is to create an array of alternate positive and negative numbers.
// Note: Array should start with positive number.


// Relative order of elements can change
// O(n) time and O(1) space
class Solution {
    void rearrange(int arr[], int n) {
        int j = -1;
        for(int i = 0; i < n; i++) {
            if(arr[i] < 0) {
                j++;
                swap(arr, i, j);
            }
        }
        int neg = 0;
        int pos = j + 1;
        
        while(pos < n && neg < pos && arr[neg] < 0) {
            swap(arr, neg, pos);
            pos++;
            neg += 2;
        }
    }
    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// Relative order of elements cannot change
// O(n) time and O(n) space
class Solution {
    void rearrange(int arr[], int n) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(arr[i] >= 0) {
                pos.add(arr[i]);
            }
            else {
                neg.add(arr[i]);
            }
        }
        int i = 0;
        int j = 0;
        int k = 0;
        while(j < pos.size() && k < neg.size()) {
            if(i % 2 == 0) {
                arr[i++] = pos.get(j++);
            }
            else {
                arr[i++] = neg.get(k++);
            }
        }
        while(j < pos.size()) {
            arr[i++] = pos.get(j++);
        }
        while(k < neg.size()) {
            arr[i++] = neg.get(k++);
        }
    }
}
