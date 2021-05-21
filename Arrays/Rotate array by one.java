// Given an array, 
// rotate the array by one position in clock-wise direction.

class Compute {
	// Very easy version of the rotate by k elements problem.
    public void rotate(long arr[], long n) {
        reverse(arr, 0, (int) n - 2);
        reverse(arr, 0, (int) n - 1);
    }
    public void reverse(long[] arr, int i, int j) {
        while(i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
    public void swap(long[] arr, int i, int j) {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
