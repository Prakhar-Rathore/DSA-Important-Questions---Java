// Given an encoded string where repetitions of substrings are represented as substring followed by count of substrings. 
// For example, if encrypted string is “ab2cd2” and k=4 , so output will be ‘b’ because decrypted string is “ababcdcd” and 4th character is ‘b’.



public class Solution {
    public static char kThCharaterOfDecryptedString(String str, Long k) {
    	int n = str.length();
        StringBuilder num = new StringBuilder();
        int i = 0;
        int j = 0;
        while(i < n) {
            j = i;
            int length = 0;
            while(j < n && !isDigit(str.charAt(j))) {
                length++;
                j++;
            }
            while(j < n && isDigit(str.charAt(j))) {
                num.append(str.charAt(j++));
            }
            long x = Long.parseLong(num.toString()) * length;
            if(x >= k) {
                k--;
                int index = (int) (k % length);
                return str.charAt(i + index);
            }
            else {
                k -= x;
                i = j;
            }
            num.setLength(0);
        }
        return str.charAt((int) (k - 1));
    }
    public static boolean isDigit(char c) {
        return c >= 48 && c <= 57;
    }
}
