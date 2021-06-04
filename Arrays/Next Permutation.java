// Implement next permutation, 
// which rearranges numbers into the 
// lexicographically next greater permutation of numbers.
// If such an arrangement is not possible, 
// it must rearrange it as the lowest possible order 
// (i.e., sorted in ascending order).
// The replacement must be in place and use only constant extra memory.



class Solution {
	// (Tricky stuff)[https://youtu.be/6qXO72FkqwM]
    public void nextPermutation(int[] arr) {
        int n = arr.length;
        if(n == 1) {
            return;
        }
        int lh = -1;
        int i = 1;
        while(i < n) {
            if(arr[i] > arr[i - 1]) {
                lh = i;
            }
            i++;
        }
        if(lh == -1) {
            int l = 0;
            int h = n - 1;
            while(l < h) {
                swap(arr, l, h);
                l++;
                h--;
            }
            return;
        }
        i = lh - 1;
        for(int j = lh; j < n; j++) {
            if(arr[j] > arr[i] && arr[j] < arr[lh]) {
                lh = j;
            }
        }
        swap(arr, i, lh);
        Arrays.sort(arr, i + 1, n);
    }
    public void swap(int[] arr, int l, int h) {
        int temp = arr[l];
        arr[l] = arr[h];
        arr[h] = temp;
    }
}
