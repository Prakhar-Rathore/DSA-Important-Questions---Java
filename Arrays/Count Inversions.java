// Given an array of integers. 
// Find the Inversion Count in the array. 
// Inversion Count: For an array, 
// inversion count indicates how far (or close) the array is from being sorted. 
// If array is already sorted then the inversion count is 0. 
// If an array is sorted in the reverse order then the inversion count is the maximum. 
// Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

class Solution {
	// Merge Sort approach to count the inversions.
    static long count = 0;
    static long inversionCount(long arr[], long n) {
        count = 0; // Very imp step, we need to set the global count to 0, otherwise in multiple test case inputs, it will give wrong answer.
        mergeSort(arr, 0, (int) n - 1);
        return count;
    }
    static long[] mergeSort(long[] arr, int l, int h) {
        if(l == h) {
            long[] res = new long[1];
            res[0] = arr[l];
            return res;
        }
        int mid = l + (h - l) / 2;
        long[] left = mergeSort(arr, l, mid);
        long[] right = mergeSort(arr, mid + 1, h);
        long[] res = merge(left, right);
        return res;
    }
    static long[] merge(long[] left, long[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        int n = left.length;
        int m = right.length;
        long[] res = new long[n + m];
        while(i < n && j < m) {
            if(left[i] <= right[j]) {
                res[k++] = left[i++];
            }
            else {
                count += n - i; // Crux of the question
                res[k++] = right[j++];
            }
        }
        while(i < n) {
            res[k++] = left[i++];
        }
        while(j < m) {
            res[k++] = right[j++];
        }
        return res;
    }
}
