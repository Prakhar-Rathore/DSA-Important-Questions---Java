// Given a string s, count the number of distinct, non-empty subsequences of s .
// Since the result may be large, return the answer modulo 109 + 7.



class Solution {
    public int distinctSubseqII(String s) {
        final int mod = 1_000_000_007;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int[] hash = new int[26];
        Arrays.fill(hash, -1);
        for(int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] * 2 % mod;
            char c = s.charAt(i - 1);
            if(hash[c - 'a'] >= 0) {
                dp[i] -= dp[hash[c - 'a'] - 1];
            }
            dp[i] %= mod;
            hash[c - 'a'] = i;
        }
        dp[n]--;
        if(dp[n] < 0) {
            dp[n] += mod;
        }
        return dp[n];
    }
}
