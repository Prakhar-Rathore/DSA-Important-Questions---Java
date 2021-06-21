// Given a string consisting only of 1’s and 0’s. 
// In one flip we can change any continuous sequence of this string. 
// Find this minimum number of flips so the string consist of same characters only.



public static int solution(String str) {
    int n = str.length();
    int one = 0;
    int zero = 0;
    for(int i = 0; i < n; i++) {
        char c = str.charAt(i);
        if(c == '1') {
            while(i < n && str.charAt(i) == '1') {
                i++;
            }
            one++;
        }
        else {
            while(i < n && str.charAt(i) == '0') {
                i++;
            }
            zero++;
        }
        i--;
    }
    return Math.min(one, zero);
}
