// Given a string S, the task is to count number of subsequences of the form aibjck, where i >= 1, j >=1 and k >= 1.
// Note: 
// 1. Two subsequences are considered different if the set of array indexes picked for the 2 subsequences are different.
// 2. For large test cases, output value will be too large, return the answer MODULO 10^9+7



class Solution {
    final static int mod = 1_000_000_007;
    public int fun(String s) {
        int n = s.length();
        int a = 0;
        int ab = 0;
        int abc = 0;
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == 'a') {
                a = (1 + (2 * a) % mod) % mod;
            }
            else if(ch == 'b') {
                ab = (a + (2 * ab) % mod) % mod;
            }
            else {
                abc = (ab + (2 * abc) % mod) % mod;
            }
        }
        return abc % mod;
    }
}
