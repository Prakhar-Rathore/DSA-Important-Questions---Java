// Given a string of characters, 
// find the length of the longest proper prefix which is also a proper suffix.



class Solution {
    int lps(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int i = 1;
        int j = 0;
        while(i < n) {
            if(s.charAt(i) == s.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            }
            else {
                if(j == 0) {
                    lps[i] = 0;
                    i++;
                }
                else {
                    j = lps[j - 1];
                }
            }
        }
        return lps[n - 1];
    }
}
