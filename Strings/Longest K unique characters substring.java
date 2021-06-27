// Given a string you need to print the size of the longest possible substring that has exactly K unique characters. 
// If there is no possible substring then print -1.



class Solution {
    public int longestkSubstr(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> hm = new HashMap<>();
        int count = -1;
        int i = 0;
        int j = 0;
        while(j < n) {
            char c = s.charAt(j);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
            if(hm.size() < k) {
                j++;
            }
            else if(hm.size() == k) {
                count = Math.max(count, j - i + 1);
                j++;
            }
            else if(hm.size() > k){
                while(hm.size() > k) {
                    char ch = s.charAt(i);
                    hm.put(ch, hm.get(ch) - 1);
                    if(hm.get(ch) == 0) {
                        hm.remove(ch);
                    }
                    i++;
                }
                j++;
            }
        }
        return count;
    }
}
