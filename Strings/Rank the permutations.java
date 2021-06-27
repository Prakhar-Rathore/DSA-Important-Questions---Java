// Given a string, 
// S find the rank of the string amongst all its permutations sorted lexicographically.
// The rank can be big. So print it modulo 1000003. 
// Note: Return 0 if the characters are repeated in the string.



class Solution {
    final static int mod = 1_000_003;
    static int fact(int n) {
        return (n <= 1) ? 1 : n * fact(n - 1);
    }
    static int rank(String s) {
        int n = s.length();
        int[] hash = new int[26];
        for(char c : s.toCharArray()) {
            if(hash[c - 'a'] != 0) {
                return 0;
            }
            hash[c - 'a']++;
        }
        int rank = 1;
        int factorial = fact(n);
        for(int i = 0; i < n; i++) {
            factorial /= (n - i);
            char c = s.charAt(i);
            int count = 0;
            for(int j = i + 1; j < n; j++) {
                if(s.charAt(j) < c) {
                    count++;
                }
            }
            count *= factorial;
            rank += count;
        }
        return rank % mod;
    }
}
