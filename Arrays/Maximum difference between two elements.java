// Given an array arr[] of integers, 
// find out the maximum difference between any two elements such that 
// larger element appears after the smaller number. 

class Solution {
	public static int solution(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
            for(int j = i + 1; j < n; j++) {
                res = Math.max(res, arr[j] - min);
            }
        }
        return res;
    }
}
