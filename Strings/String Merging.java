// For a string S, let's define a function F(S) as the minimum number of blocks consisting of consecutive identical characters in S. 
// In other words, F(S) is equal to 1 plus the number of valid indices i such that Si ≠ Si+1.
// You are given two strings A and B with lengths N and M respectively. 
// You should merge these two strings into one string C with length N+M. 
// Specifically, each character of C should come either from A or B; 
// all characters from A should be in the same relative order in C as in A and all characters from B 
// should be in the same relative order in C as in B.
// Compute the minimum possible value of F(C).


// Tricky stuff
public static long solution(String str1, String str2, int n, int m) {
    int count = 2;
    StringBuilder s1 = new StringBuilder(" ");
    StringBuilder s2 = new StringBuilder(" ");
    s1.append(str1.charAt(0));
    s2.append(str2.charAt(0));
    for(int i = 1; i < n; i++) {
        if(str1.charAt(i) != str1.charAt(i - 1)) {
            count++;
            s1.append(str1.charAt(i));
        }
    }
    for(int i = 1; i < m; i++) {
        if(str2.charAt(i) != str2.charAt(i - 1)) {
            count++;
            s2.append(str2.charAt(i));
        }
    }
    n = s1.length() - 1;
    m = s2.length() - 1;
    int[][] dp = new int[n + 1][m + 1];
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= m; j++) {
            if(s1.charAt(i) == s2.charAt(j)) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            }
            else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }
    return count - (dp[n][m]);
}
