// Given a string str of lowercase ASCII characters, 
// Count the number of distinct continuous palindromic sub-strings which are present in the string str.



class Solution {
    int palindromeSubStrs(String str) {
        int n = str.length();
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            int l = i;
            int h = i;
            while(l >= 0 && h < n && str.charAt(l) == str.charAt(h)) {
                set.add(str.substring(l, h + 1));
                l--;
                h++;
            }
            l = i;
            h = i + 1;
            while(l >= 0 && h < n && str.charAt(l) == str.charAt(h)) {
                set.add(str.substring(l, h + 1));
                l--;
                h++;
            }
        }
        return set.size();
    }
}
