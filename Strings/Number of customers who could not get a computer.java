public static int solution(String s, int k) {
    int[] hash = new int[26];
    int count = 0;
    int temp = 0;
    for(char c : s.toCharArray()) {
        if(hash[c - 'A'] == 0 && temp < k) {
            temp++;
            hash[c - 'A'] = 1;
        }
        else if(hash[c - 'A'] == 1 && temp <= k) {
            temp--;
            hash[c - 'A'] = 0;
        }
        else {
            count ++;
        }
    }
    return count / 2;
}
