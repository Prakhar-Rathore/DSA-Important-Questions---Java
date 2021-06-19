// Given two strings of lowercase alphabets and a value K, 
// your task is to complete the given function which tells if 
// two strings are K-anagrams of each other or not.
// Two strings are called K-anagrams if both of the below conditions are true.
// 1. Both have same number of characters.
// 2. Two strings can become anagram by changing at most K characters in a string.


class GfG {
    boolean areKAnagrams(String s1, String s2, int k) {
        if(s1.length() != s2.length()) {
            return false;
        }
        int[] hash = new int[26];
        int count = 0;
        for(int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            hash[c - 'a']++;
        }
        for(int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            hash[c - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
            count += hash[i] > 0 ? hash[i] : 0;
        }
        return count <= k;
    }
}
