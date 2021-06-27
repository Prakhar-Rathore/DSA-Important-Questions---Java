//Given a string s and a string array dictionary, 
// return the longest string in the dictionary that can be formed by deleting some of the given string characters. 
// If there is more than one possible result, 
// return the longest word with the smallest lexicographical order. 
// If there is no possible result, return the empty string.


// This approach uses sorting and custom comparator
static String findLongestWord(String s, List<String> d) {
    d.sort(Comparator.naturalOrder());
    String res = "";
    for (String value : d) {
        if (isSubsequence(s, value) && value.length() > res.length()) {
            res = value;
        }
    }
    return res;
}
static boolean isSubsequence(String a, String b) {
    int n = a.length();
    int m = b.length();
    if(m > n) {
        return false;
    }
    int j = 0;
    for(int i = 0; i < n; i++) {
        if(a.charAt(i) == b.charAt(j)) {
            j++;
        }
        if(j == m) {
            return true;
        }
    }
    return j == m;
}


// No sorting approach
class Solution {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String value : d) {
            if (isSubsequence(s, value)) {
                if(value.length() > res.length()) {
                    res = value;
                }
                if(value.length() == res.length() && value.compareTo(res) < 0) {
                    res = value;
                }
            }
        }
        return res;
    }
    static boolean isSubsequence(String a, String b) {
        int n = a.length();
        int m = b.length();
        if(m > n) {
            return false;
        }
        int j = 0;
        for(int i = 0; i < n; i++) {
            if(a.charAt(i) == b.charAt(j)) {
                j++;
            }
            if(j == m) {
                return true;
            }
        }
        return j == m;
    }
}
