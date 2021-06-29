// Two strings str1 and str2 are called isomorphic 
// if there is a one to one mapping possible for every character of str1 to every character of str2. 
// And all occurrences of every character in ‘str1’ map to same character in ‘str2’.



class Solution {
    public static boolean areIsomorphic(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }
        int n = str1.length();
        int[] hash1 = new int[128];
        int[] hash2 = new int[128];
        for(int i = 0; i < n; i++) {
            char a = str1.charAt(i);
            char b = str2.charAt(i);
            if(hash1[a] == 0 && hash2[b] == 0) {
                hash1[a] = b;
                hash2[b] = a;
            }
            else if(hash1[a] != b && hash2[b] != a) {
                return false;
            }
        }
        return true;
    }
}
