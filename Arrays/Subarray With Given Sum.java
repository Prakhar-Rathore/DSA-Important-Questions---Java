// Given an unsorted array A of size n that contains only non-negative integers, 
// find a continuous sub-array which adds to a given number s.

class Solution {
	// The crux of the problem is sliding window approach.
	// Add the elements, to current sum till it is less than S. 
	// If it becomes more than S, start deleting elements from start in the current sum. 
	// if the current sum again becomes less than S, again start adding elements to it. 
	// In between also check, if the current sum becomes equal to S.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 1;
        int sum = arr[0];
        while(i < n) {
            if(sum < s && j < n) {
                sum += arr[j++];
            }
            else if(sum == s) {
                res.add(i + 1);
                res.add(j);
                return res;
            }
            else {
                sum -= arr[i++];
            }
        }
        res.add(-1);
        return res;
    }
}
