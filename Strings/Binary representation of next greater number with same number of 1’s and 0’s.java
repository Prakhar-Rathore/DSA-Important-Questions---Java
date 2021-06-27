// Given a binary input that represents binary representation of positive number n, 
// find binary representation of smallest number greater than n with same number of 1’s and 0’s as in binary representation of n



public static String solution(String s) {
    int n = s.length();
    if(n == 1) {
        if(s.equals("1")) {
            return "10";
        }
        else {
            return "1";
        }
    }
    int lh = -1;
    int i = 1;
    while(i < n) {
        if(s.charAt(i) > s.charAt(i - 1)) {
            lh = i;
        }
        i++;
    }
    if(lh == -1) {
        StringBuilder res = new StringBuilder();
        res.append('1');
        while(n-- > 0) {
            res.append('0');
        }
        return res.toString();
    }
    i = lh - 1;
    for(int j = lh; j < n; j++) {
        if(s.charAt(j) > s.charAt(i) && s.charAt(j) < s.charAt(lh)) {
            lh = j;
        }
    }
    char[] c = s.toCharArray();
    swap(c, i, lh);
    Arrays.sort(c, i + 1, n);
    return new String(c);
}
public static void swap(char[] arr, int l, int h) {
    char temp = arr[l];
    arr[l] = arr[h];
    arr[h] = temp;
}
