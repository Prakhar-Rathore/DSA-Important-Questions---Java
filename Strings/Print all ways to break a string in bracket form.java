// Given a string, find all ways to break the given string in bracket form. 
// Enclose each substring within a parenthesis.



public static void solution(String s, int index, String temp) {
    if(index == s.length()) {
        System.out.println(temp);
    }
    for(int i = index; i < s.length(); i++) {
        String a = "(" + s.substring(index, i + 1) + ")";
        solution(s, i + 1, temp + a);
    }
}
