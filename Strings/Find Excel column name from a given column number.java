// Given a positive integer N, 
// return its corresponding column title as it would appear in an Excel sheet.
// For N =1 we have column A, for 27 we have AA and so on.
// Note: The alphabets are all in uppercase.



class Solution {
    public String excelColumn(int n) {
        StringBuilder res = new StringBuilder();
        while(n > 0) {
            int rem = n % 26;
            if(rem == 0) {
                res.append('Z');
                n = (n / 26) - 1;
            }
            else {
                res.append((char)((rem - 1) + 'A'));
                n /= 26;
            }
        }
        return res.reverse().toString();
    }
}
