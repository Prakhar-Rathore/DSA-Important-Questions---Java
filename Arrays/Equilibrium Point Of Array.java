//Given an array A of n positive numbers. 
//The task is to find the first Equilibium Point in the array. 
//Equilibrium Point in an array is a position such that the sum of elements before it is equal to the sum of elements after it.

class Solution {
    // maintain total sum and left sum variables
    // the point at which total sum = left sum is the index
    // subtract current element from total sum
    // add current element to the left sum
    // eventually they will become equal, if the point exists
    public static int equilibriumPoint(long arr[], int n) {
        long total_sum = 0;
        for(int i = 0; i < n; i++) {
            total_sum += arr[i];
        }
        long left_sum = 0;
        for(int i = 0; i < n; i++) {
            total_sum -= arr[i];
            if(total_sum == left_sum) {
                return i + 1;
            }
            left_sum += arr[i];
        }
        return -1;
    }
}
