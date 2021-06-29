// Given a string and number of rows ‘n’. 
// Print the string formed by concatenating n rows when the input string is written in row-wise Zig-Zag fashion.



class Solution {
    String convert(String s, int k) {
        int n = s.length();
        if(n == 1 || k == 1) {
            return s;
        }
        String[] arr = new String[k];
        Arrays.fill(arr, "");
        for(int i = 0; i < n;) {
            for(int j = 0; j < k && i < n; j++, i++) {
                arr[j] += s.charAt(i);
            }
            for(int j = k - 2; j > 0 && i < n; j--, i++) {
                arr[j] += s.charAt(i);
            }
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < k; i++) {
            res.append(arr[i]);
        }
        return res.toString();
    }
}
