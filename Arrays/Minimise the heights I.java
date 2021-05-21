// Given an array arr[] denoting heights of N towers and a positive integer K, 
// you have to modify the height of each tower either by increasing or decreasing them by K only once.
// Find out what could be the possible minimum difference of 
// the height of shortest and longest towers after you have modified each tower.
// Very tricky stuff, explanation here[https://stackoverflow.com/questions/32233916/minimum-difference-between-heights-of-towers/63220955#63220955]
// Assume the height of the tower can be negative.

class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int res = arr[n - 1] - arr[0];
        for(int i = 1; i < n; i++) {
        	// the height can be negative here, so no if statement.
            int min = Math.min(arr[0] + k, arr[i] - k);
            int max = Math.max(arr[n - 1] - k, arr[i - 1] + k);
            res = Math.min(res, max - min);
        }
        return res;
    }
}
