// Given an array of strings, 
// return all groups of strings that are anagrams. 
// The groups must be created in order of their appearance in the original array. 
// Look at the sample case for clarification.


class Solution {
    public List<List<String>> Anagrams(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(String str : strings) {
            int n = str.length();
            int hash[] = new int[26];
            for(int i = 0; i < n; i++) {
                char c = str.charAt(i);
                hash[c - 'a']++;
            }
            String temp = Arrays.toString(hash);
            if(map.containsKey(temp)) {
                map.get(temp).add(str);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(temp, list);
            }
        }
        for(String str : map.keySet()) {
            res.add(map.get(str));
        }
        return res;
    }
}
