// Given two strings A and B, find if A is a subsequence of B.



class Solution{
    boolean isSubSequence(String a, String b){
        int m = a.length();
        int n = b.length();
        if(n < m) {
            return false;
        }
        int j = 0;
        for(int i = 0; i < n; i++) {
            if(a.charAt(j) == b.charAt(i)) {
                j++;
            }
            if(j == m) {
                return true;
            }
        }
        if(j == m) {
            return true;
        }
        return false;
    }
}
