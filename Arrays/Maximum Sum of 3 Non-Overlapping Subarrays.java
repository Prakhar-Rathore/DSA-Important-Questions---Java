// Given an integer array nums and an integer k, 
// find three non-overlapping subarrays of length k 
// with maximum sum and return them.
// Return the result as a list of indices representing 
// the starting position of each interval (0-indexed). 
// If there are multiple answers, 
// return the lexicographically smallest one.

// Case 1 - Time O(n) and space O(n)
class Solution {
	// Very tricky stuff
    public int[] maxSumOfThreeSubarrays(int[] arr, int k) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] res = new int[3];
        int[] sum = new int[n + 1];
        for(int i = 0; i < n; i++) {
            sum[i + 1] += sum[i] + arr[i];
        }
        int max_sum = sum[k] - sum[0];
        for(int i = k; i < n; i++) {
            int temp = sum[i + 1] - sum[i - k + 1];
            if(temp > max_sum) {
                left[i] = i + 1 - k;
                max_sum = temp;
            }
            else {
                left[i] = left[i - 1];
            }
        }
        right[n - k] = n - k;
        max_sum = sum[n] - sum[n - k];
        for(int i = n - k - 1; i >= 0; i--) {
            int temp = sum[i + k] - sum[i];
            if(temp >= max_sum) {
                right[i] = i;
                max_sum = temp;
            }
            else {
                right[i] = right[i + 1];
            }
        }
        max_sum = 0;
        for(int i = k; i <= n - 2 * k; i++) {
            int l = left[i - 1];
            int r = right[i + k];
            int temp = (sum[i+k]-sum[i]) + (sum[l+k]-sum[l]) + (sum[r+k]-sum[r]);
            if(temp > max_sum) {
                max_sum = temp;
                res[0] = l;
                res[1] = i;
                res[2] = r;
            }
        }
        return res;
    }
}

// Case 2 - Time O(n) and space O(1)
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] arr, int k) {
        int n = arr.length;
        int[] best_one = {0};
        int[] best_two = {0, k};
        int[] best_three = {0, k, 2 * k};

        int sum_one = 0;
        int sum_two = 0;
        int sum_three = 0;

        for(int i = 0; i < k; i++) {
            sum_one += arr[i];
        }
        for(int i = k; i < 2 * k; i++) {
            sum_two += arr[i];
        }
        for(int i = 2 * k; i < 3 * k; i++) {
            sum_three += arr[i];
        }

        int best_one_sum = sum_one;
        int best_two_sum = sum_one + sum_two;
        int best_three_sum = sum_one + sum_two + sum_three;

        int index_one = 1;
        int index_two = k + 1;
        int index_three = 2 * k + 1;

        while(index_three <= n - k) {

            sum_one = sum_one - arr[index_one - 1] + arr[index_one + k - 1];
            sum_two = sum_two - arr[index_two - 1] + arr[index_two + k - 1];
            sum_three = sum_three - arr[index_three - 1] + arr[index_three + k - 1];

            // Update best single window
            if (sum_one > best_one_sum) {
                best_one[0] = index_one;
                best_one_sum = sum_one;
            }

            // Update best two windows
            if (sum_two + best_one_sum > best_two_sum) {
                best_two[0] = best_one[0];
                best_two[1] = index_two;
                best_two_sum = sum_two + best_one_sum;
            }

            // Update best three windows
            if (sum_three + best_two_sum > best_three_sum) {
                best_three[0] = best_two[0];
                best_three[1] = best_two[1];
                best_three[2] = index_three;
                best_three_sum = sum_three + best_two_sum;
            }

            // Update the current positions
            index_one += 1;
            index_two += 1;
            index_three += 1;
        }
        return best_three;
    }
}
