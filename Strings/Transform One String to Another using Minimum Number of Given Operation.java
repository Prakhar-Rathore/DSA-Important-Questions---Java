// Given two strings A and B, the task is to convert A to B if possible. 
// The only operation allowed is to put any character from A and insert it at front. 
// Find if it’s possible to convert the string. 
// If yes, then output minimum no. of operations required for transformation.



public static int solution(String a, String b) {
    if(a.length() != b.length()) {
        return -1;
    }
    int n = a.length();
    int[] hash = new int[26];
    for(char c : a.toCharArray()) {
        hash[c - 'A']++;
    }
    for(char c : b.toCharArray()) {
        hash[c - 'A']--;
    }
    for(int i : hash) {
        if(i != 0) {
            return -1;
        }
    }
    int i = n - 1;
    int j = n - 1;
    int count = 0;
    while(i >= 0) {
        if(a.charAt(i) != b.charAt(j)) {
            count++;
        }
        else {
            j--;
        }
        i--;
    }
    return count;
}
