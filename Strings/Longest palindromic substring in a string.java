// Given a string S, find the longest palindromic substring in S. 
// Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). 
// Palindrome string: A string which reads the same backwards. 
// More formally, S is palindrome if reverse(S) = S. Incase of conflict, 
// return the substring which occurs first ( with the least starting index).



// Slight modification of count palindrome substrings in a string.
class Solution{
    static String longestPalin(String str){
        StringBuilder res = new StringBuilder();
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        for(int k = 0; k < n; k++) {
            for(int i = 0, j = k; j < n; j++, i++) {
                if(i == j) {
                    dp[i][j] = true;
                    if(j - i + 1 > res.length()) {
                        res.setLength(0);
                        res.append(str.substring(i, j + 1));
                    }
                }
                else if(str.charAt(i) == str.charAt(j)) {
                    if(j - i == 1 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if(j - i + 1 > res.length()) {
                            res.setLength(0);
                            res.append(str.substring(i, j + 1));
                        }
                    }
                }
            }
        }
        return res.toString();
    }
}
