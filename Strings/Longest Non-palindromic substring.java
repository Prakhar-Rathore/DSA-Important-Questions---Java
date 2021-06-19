// Given a string of size n. 
// The task is to find the length of the largest substring which is not palindrome.


public static int solution(String s) {
    int n = s.length();
    boolean flag = true;
    for(int i = 1; i < n; i++) {
        if(s.charAt(i) != s.charAt(i - 1)) {
            flag = false;
            break;
        }
    }
    if(flag) {
        return 0;
    }
    int l = 0;
    int h = n - 1;
    while(l < h) {
        if(s.charAt(l++) != s.charAt(h--)) {
            return n;
        }
    }
    return n - 1;
}
