// Given an array of strings strs, group the anagrams together. 
// You can return the answer in any order.
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
// typically using all the original letters exactly once.


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> hm = new HashMap<>();
        for(String str : strs) {
            HashMap<Character, Integer> temp = new HashMap<>();
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                temp.put(c, temp.getOrDefault(c, 0) + 1);
            }
            if(hm.containsKey(temp)) {
                hm.get(temp).add(str);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(str);
                hm.put(temp, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(HashMap<Character, Integer> map : hm.keySet()) {
            res.add(hm.get(map));
        }
        return res;
    }
}


// This solution is way faster in leetcode, due to use of char[] instead
// of a complex HashMap<Character, Integer>
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for(String str : strs) {
            char[] hash = new char[26];
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                hash[c - 'a']++;
            }
            String key = new String(hash);
            if(hm.containsKey(key)) {
                hm.get(key).add(str);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(str);
                hm.put(key, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(String key : hm.keySet()) {
            res.add(hm.get(key));
        }
        return res;
    }
}
