// Given a sorted array of positive integers. 
// Your task is to rearrange  the array elements alternatively 
// i.e first element should be max value, 
// second should be min value, 
// third should be second max, 
// fourth should be second min and so on.

class Solution {
	// The genius strategy to store two numbers at a single array
	// index. The intuition behind this is
	// p % q = r
	// p / q = s
	// p = s * q + r
    public static void rearrange(int arr[], int n) {
        int q = arr[n - 1] + 1;
        int l = 0;
        int h = n - 1;
        
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                int r = arr[i] % q;
                int s = arr[h--] % q;
                arr[i] = s * q + r;
            }
            else {
                int r = arr[i] % q;
                int s = arr[l++] % q;
                arr[i] = s * q + r;
            }
        }
        
        for(int i = 0; i < n; i++) {
            arr[i] /= q;
        }
    }
}
