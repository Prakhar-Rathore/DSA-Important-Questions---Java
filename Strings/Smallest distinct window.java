// Given a string 's'. 
// The task is to find the smallest window length that contains 
// all the characters of the given string at least one time.
// For eg. A = “aabcbcdbca”, 
// then the result would be 4 as of the smallest window will be “dbca”.



class Solution {
    public String findSubString(String str) {
        int n = str.length();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(str.charAt(i));
        }
        int unique = set.size();
        StringBuilder res = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        while(true) {
            boolean f1 = false;
            boolean f2 = false;
            while(i < n - 1 && map.size() < unique) {
                i++;
                char c = str.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
                f1 = true;
            }
            while(j < i && map.size() == unique) {
                j++;
                StringBuilder temp = new StringBuilder(str.substring(j, i + 1));
                if(temp.length() < res.length() || res.length() == 0) {
                    res = temp;
                }
                char c = str.charAt(j);
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) {
                    map.remove(c);
                }
                f2 = true;
            }
            if(!f1 && !f2) {
                break;
            }
        }
        return res.toString();
    }
}
