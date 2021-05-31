// Given an array(0-based indexing), 
// you have to find the max sum of i*A[i] where A[i] is the element 
// at index i in the array. 
// The only operation allowed is to rotate(clock-wise or counter clock-wise) 
// the array any number of times.

class GfG {
	// This approach is very logical and mathematical, we just need to
	// store total sum and the rotated sum can easily be calculated
	// using the formula.
    int max_sum(int arr[], int n) {
        int tsum = 0;
        int isum = 0;
        for(int i = 0; i < n; i++) {
            tsum += arr[i];
            isum += i * arr[i];
        }
        int max_sum = isum;
        for(int i = 1; i < n; i++) {
            isum = isum + tsum - n * arr[n - i];
            max_sum = Math.max(max_sum, isum);
        }
        return max_sum;
    }	
}
