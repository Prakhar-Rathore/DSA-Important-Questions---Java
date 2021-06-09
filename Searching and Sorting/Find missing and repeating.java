// Given an unsorted array Arr of size N of positive integers.
// One number 'A' from set {1, 2, …N} is missing and one number 'B' occurs twice in array. 
// Find these two numbers.

// Very logical solution, not very intuitive
class Solve {
    int[] findTwoElement(int arr[], int n) {
        int[] res = new int[2];
        for(int i = 0; i < n; i++) {
            int x = Math.abs(arr[i]);
            if(arr[x - 1] > 0) {
                arr[x - 1] *= -1;
            }
            else {
                res[0] = x;
            }
        }
        for(int i = 0; i < n; i++) {
            if(arr[i] > 0) {
                res[1] = i + 1;
                break;
            }
        }
        return res;
    }
}
