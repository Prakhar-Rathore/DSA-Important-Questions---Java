// Given a string representing the starting number, 
// and a maximum number of changes allowed, 
// create the largest palindromic string of digits possible 
// or the string '-1' if it is not possible 
// to create a palindrome under the contstraints.


class Result {
    public static String highestValuePalindrome(String s, int n, int k) {
        if(k >= n) {
            StringBuilder str = new StringBuilder(s);
            for(int i = 0; i < n; i++) {
                str.setCharAt(i, '9');
            }
            return str.toString();
        }
        StringBuilder str = new StringBuilder(s);
        int l = 0;
        int h = n - 1;
        boolean[] hash = new boolean[n];
        while(l < h) {
            char c1 = str.charAt(l);
            char c2 = str.charAt(h);
            if (c1 != c2) {
                if (c1 > c2) {
                    str.setCharAt(h, c1);
                }
                else {
                    str.setCharAt(l, c2);
                }
                k--;
                hash[l] = true;
            }
            l++;
            h--;
        }
        if(k < 0) {
            return "-1";
        }
        else if(k == 0) {
            return str.toString();
        }
        else {
            for(int i = 0; i < n / 2; i++) {
                if(str.charAt(i) != '9') {
                    if(hash[i] && k > 0) {
                        str.setCharAt(i, '9');
                        str.setCharAt(n - i - 1, '9');
                        k--;
                    }
                    if(!hash[i] && k > 1) {
                        str.setCharAt(i, '9');
                        str.setCharAt(n - i - 1, '9');
                        k -= 2;
                    }
                }

            }
            if(n % 2 == 1 && k > 0) {
                str.setCharAt(n / 2, '9');
            }
            return str.toString();
        }    
    }

}
