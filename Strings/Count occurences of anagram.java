// Given a word pat and a text txt. 
// Return the count of the occurences of anagrams of the word in the text.


class Solution {
    int search(String pat, String str) {
        int[] hash = new int[26];
        int n = str.length();
        int count = 0;
        for(int i = 0; i < pat.length(); i++) {
            char c = pat.charAt(i);
            hash[c - 'a']++;
        }
        String temp = Arrays.toString(hash);
        int[] freq = new int[26];
        for(int i = 0; i < pat.length(); i++) {
            char c = str.charAt(i);
            freq[c - 'a']++;
        }
        for(int i = pat.length(); i < n; i++) {
            if(Arrays.toString(freq).equals(temp)) {
                count++;
            }
            char a = str.charAt(i);
            char d = str.charAt(i - pat.length());
            freq[a - 'a']++;
            freq[d - 'a']--;
        }
        if(Arrays.toString(freq).equals(temp)) {
            count++;
        }
        return count;
    }
}
