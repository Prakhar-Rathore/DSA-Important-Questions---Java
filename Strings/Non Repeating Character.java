// Given a string S consisting of lowercase Latin Letters. 
// Find the first non-repeating character in S.



class Solution {
    static char nonrepeatingCharacter(String s) {
        int n = s.length();
        int[] hash = new int[26];
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            hash[c - 'a']++;
        }
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(hash[c - 'a'] == 1) {
                return c;
            }
        }
        return '$';
    }
}

