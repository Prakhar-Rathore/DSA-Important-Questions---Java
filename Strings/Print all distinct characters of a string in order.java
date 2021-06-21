// Given a string, find the all distinct (or non-repeating characters) in it. 
// For example, if the input string is “Geeks for Geeks”, 
// then output should be ‘for’ and if 
// input string is “Geeks Quiz”, then output should be ‘GksQuiz’.
// The distinct characters should be printed in same order as they appear in input string.



public static String solution(String str) {
    int n = str.length();
    StringBuilder res = new StringBuilder();
    HashMap<Character, Integer> map = new HashMap<>();
    for(int i = 0; i < n; i++) {
        char c = str.charAt(i);
        if(c != ' ') {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
    }
    for(int i = 0; i < n; i++) {
        char c = str.charAt(i);
        if(map.getOrDefault(c, 0) == 1) {
            res.append(c);
        }
    }
    return res.toString();
}
