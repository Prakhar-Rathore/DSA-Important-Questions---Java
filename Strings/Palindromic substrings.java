// Given a string s, return the number of palindromic substrings in it.
// A string is a palindrome when it reads the same backward as forward.
// A substring is a contiguous sequence of characters within the string.


// Dynamic programming approach
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        boolean[][] dp = new boolean[n][n];
        for(int k = 0; k < n; k++) {
            for(int i = 0, j = k; j < n; j++, i++) { // look at this genius loop
                if(i == j) {
                    dp[i][j] = true;
                    count++;
                }
                else if(s.charAt(i) == s.charAt(j)) {
                    if(j - i == 1 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}


// No dynamic programming creative solution
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for(int i = 0; i < n; i++) {
            count += palindrome(s, i, i);
            count += palindrome(s, i, i + 1);
        }
        return count;
    }
    public int palindrome(String s, int l, int r) {
        int count = 0;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
            count++;
        }
        return count;
    }
}
