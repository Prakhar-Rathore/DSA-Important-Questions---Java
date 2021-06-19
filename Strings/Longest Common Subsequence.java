// Given two strings text1 and text2, 
// return the length of their longest common subsequence. 
// If there is no common subsequence, return 0.
// A subsequence of a string is a new string generated from the original string 
// with some characters (can be none) deleted 
// without changing the relative order of the remaining characters.
// For example, "ace" is a subsequence of "abcde".
// A common subsequence of two strings is a subsequence 
// that is common to both strings.


// Use of dp matrix, tricky stuff [https://youtu.be/0Ql40Llp09E]
class Solution {
    public int longestCommonSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--) {
                char c1 = str1.charAt(i);
                char c2 = str2.charAt(j);
                
                if(c1 == c2) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}
