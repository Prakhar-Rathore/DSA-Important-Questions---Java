// Given a string of lower alphabet characters, 
// count total substring of this string which are anagram to each other.



public static int solution(String str) {
    int n = str.length();
    int count = 0;
    HashMap<String, Integer> map = new HashMap<>();
    for(int i = 0; i < n; i++) {
        for(int j = i; j < n; j++) {
            char[] c = str.substring(i, j + 1).toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
    }
    for(String c : map.keySet()) {
        int x = map.get(c);
        if(x > 1) {
            count += x * (x - 1) / 2;
        }
    }
    return count;
}
