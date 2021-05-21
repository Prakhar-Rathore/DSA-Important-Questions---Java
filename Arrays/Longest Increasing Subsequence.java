// Given an array of integers, 
// find the length of the longest (strictly) increasing subsequence from the given array.

// There are two very good ways to solve this problem.
// Case 1 - Uses O(n^2) time complexity (Not the most efficient)

class Solution {
    static int longestSubsequence(int n, int arr[]) {
        int[] dp = new int[n];
        int res = 0;
        for(int i = 0; i < n; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    if(dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

// Case 2 - Uses O(n logn) time complexity (Best method)

class Solution {
	// Uses binary search so the second loop of O(n) is replaced by O(n logn)
    static int longestSubsequence(int n, int arr[]) {
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(arr[0]);
        for(int i = 1; i < n; i++) {
            if(arr[i] > dp.get(dp.size() - 1)) {
                dp.add(arr[i]);
            }
            else {
                int l = 0;
                int h = dp.size() - 1;
                int x = arr[i];
                while(l <= h) {
                    int mid = l + (h - l) / 2;
                    if(dp.get(mid) == x) {
                        break;
                    }
                    else if(dp.get(mid) > x) {
                        h = mid - 1;
                    }
                    else {
                        l = mid + 1;
                    }
                }
                dp.set(l, x);
            }
        }
        return dp.size();
    }
} 
