public static boolean solution(String s) {
    int n = s.length();
    if(!uppercase(s.charAt(0))) {
        System.out.println("j");
        return false;
    }
    if(s.charAt(n - 1) != '.') {
        System.out.println("jj");
        return false;
    }
    if(s.contains("  ")) {
        System.out.println("jjj");
        return false;
    }
    for(int i = 0; i < n - 1; i++) {
        if(lowercase(s.charAt(i)) && uppercase(s.charAt(i + 1))) {
            return false;
        }
        if(s.charAt(i) == '.') {
            return false;
        }
        if(uppercase(s.charAt(i)) && uppercase(s.charAt(i + 1))) {
            return false;
        }
    }
    return true;
}
public static boolean uppercase(char c) {
    return c >= 65 && c <= 90;
}
public static boolean lowercase(char c) {
    return c >= 97 && c <= 122;
}
