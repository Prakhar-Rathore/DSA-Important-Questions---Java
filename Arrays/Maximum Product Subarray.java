//Given an array Arr that contains N integers (may be positive, negative or zero). 
//Find the product of the maximum product subarray.

class Solution {
	//We need to keep both min and max throughout the iteration.
    //We have three cases here
    //Case 1 - If the number is positve, dont think just multiply because it increases both max and min.
    //Case 2 - If the number is negative, now the element will make product positive with min element
    //so we swap the two numbers.
    //Case 3 - If the number is zero, we just compute the res and then min = max = 0;
    //This min = max = 0, wont break the code because of the 23 and 24 lines as we check both arr[i] and max * arr[i]
    //(similar for min * arr[i]), so in the next iteration, the next element will be stored and 0 will be removed.
    long maxProduct(int[] arr, int n) {
        long max = arr[0];
        long min = arr[0];
        long res = arr[0];
        for(int i = 1; i < n; i++) {
            if(arr[i] < 0) {
                long temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max * arr[i], arr[i]);
            min = Math.min(min * arr[i], arr[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}
