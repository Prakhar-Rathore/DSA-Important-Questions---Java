// Given a string S, find the longest palindromic substring in S. 
// Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). 
// Palindrome string: A string which reads the same backwards. 
// More formally, S is palindrome if reverse(S) = S. Incase of conflict, 
// return the substring which occurs first ( with the least starting index).



// Slight modification of count palindrome substrings in a string.
// Due to the use of n^2 space and time, this has 200ms on leetcode.
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


// This soution is much faster, 30 ms on leetcode
class Solution {
    public String longestPalindrome(String str) {
        int n = str.length();
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < n; i++) {
            String temp = palindrome(str, i, i);
            if(temp.length() > res.length()) {
                res.setLength(0);
                res.append(temp);
            }
            temp = palindrome(str, i, i + 1);
            if(temp.length() > res.length()) {
                res.setLength(0);
                res.append(temp);
            }
        }
        return res.toString();
    }
    public static String palindrome(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}
