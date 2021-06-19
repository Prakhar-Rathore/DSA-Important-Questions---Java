// Rearrange the characters of the given string to form a lexicographically first palindromic string. 
// If no such string exists display message “no palindromic string”.


public static String solution(String s) {
    int n = s.length();
    int[] hash = new int[26];
    for(int i = 0; i < n; i++) {
        char c = s.charAt(i);
        hash[c - 'a']++;
    }
    int odd = 0;
    for(int i = 0; i < 26; i++) {
        if(hash[i] % 2 == 1) {
            odd++;
        }
    }
    if(odd > 1) {
        return "impossible";
    }
    if(odd == 1 && n % 2 == 0) {
        return "impossible";
    }
    char[] res = new char[n];
    int l = 0;
    int h = n - 1;
    for(int i = 0; i < 26; i++) {
        if(hash[i] > 1) {
            while(hash[i] > 1) {
                res[l++] = (char) (i + 'a');
                res[h--] = (char) (i + 'a');
                hash[i] -= 2;
            }
        }
    }
    for(int i = 0; i < 26; i++) {
        while(hash[i] > 0) {
            res[l++] = (char) (i + 'a');
            hash[i]--;
        }
    }
    return new String(res);
}
