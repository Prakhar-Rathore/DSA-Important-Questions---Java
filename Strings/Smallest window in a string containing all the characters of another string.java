// Given two strings S and P. 
// Find the smallest window in the S consisting of all the characters of P.



class Solution {
    public static String smallestWindow(String s, String p) {
        if(s.length() < p.length()) {
            return "-1";
        }
        int[] map2 = new int[26];
        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map2[c - 'a']++;
        }
        int i = -1;
        int j = -1;
        int max = p.length();
        int count = 0;
        StringBuilder res = new StringBuilder();
        int[] map1 = new int[26];
        while(true) {
            boolean f1 = true;
            boolean f2 = true;
            while(i < s.length() - 1 && count < max) {
                i++;
                char c = s.charAt(i);
                map1[c - 'a']++;
                if(map1[c - 'a'] <= map2[c - 'a']) {
                    count++;
                }
                f1 = false;
            }
            while(j < i && count == max) {
                String temp = s.substring(j + 1, i + 1);
                if(res.length() == 0 || res.length() > temp.length()) {
                    res.setLength(0);
                    res.append(temp);
                }
                j++;
                char c = s.charAt(j);
                map1[c - 'a']--;
                if(map1[c - 'a'] < map2[c - 'a']) {
                    count--;
                }
                f2 = false;
            }
            if(f1 && f2) {
                break;
            }

        }
        return res.length() == 0 ? "-1" : res.toString();
    }
}
