//Given an array of 0s and 1s. 
//Find the length of the largest subarray with equal number of 0s and 1s.

class Solution {
	//The crux of the question lies in the fact that, if we replace all the zeros with -1
	//the question simply becomes the maximum zero sum subarray problem.
    int maxLen(int[] arr, int n) {
        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                arr[i] = -1;
            }
        }
        return zeroSumSubarray(arr, n);
    }
    int zeroSumSubarray(int[] arr, int n) {
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int res = 0;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            if(!hm.containsKey(sum)) {
                hm.put(sum, i);
            }
            else {
                res = Math.max(res, i - hm.get(sum));
            }
        }
        return res;
    }
}
