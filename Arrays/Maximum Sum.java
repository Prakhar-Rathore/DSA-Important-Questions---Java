// You are given N integer sequences A1, A2, ..., AN. 
// Each of these sequences contains N elements. 
// You should pick N elements, one from each sequence; 
// let's denote the element picked from sequence Ai by Ei. 
// For each i (2 ≤ i ≤ N), Ei should be strictly greater than Ei-1.
// Compute the maximum possible value of E1 + E2 + ... + EN. 
// If it's impossible to pick the elements E1, E2, ..., EN, print -1 instead.

// Uses greedy approach to solve the problem
static long solution(int[][] arr, int n) {
        long res = 0;
        long prev_max = Long.MAX_VALUE;
        for(int i = n - 1; i >= 0; i--) {
            long max = 0;
            for(int j = n - 1; j >= 0; j--) {
                if(arr[i][j] > max && arr[i][j] < prev_max) {
                    max = arr[i][j];
                }
            }
            if(max == 0) {
                return -1;
            }
            prev_max = max;
            res += max;
        }
        return res;
    }
