// Given an integer array of digits, 
// return the largest multiple of three that can be formed by 
// concatenating some of the given digits in any order.
// Since the answer may not fit in an integer data type, 
// return the answer as a string.
// If there is no answer return an empty string.


class Solution {
    public String largestMultipleOfThree(int[] arr) {
        int[] m1 = {1, 4, 7, 2, 5, 8};
        int[] m2 = {2, 5, 8, 1, 4, 7};
        int sum = 0;
        int[] hash = new int[10];
        for (int i : arr) {
            hash[i]++;
            sum += i;
        }
        // This while loop is the crux of the question
        while (sum % 3 != 0) {
            for (int i : sum % 3 == 1 ? m1 : m2) {
                if (hash[i] > 0) {
                    hash[i]--;
                    sum -= i;
                    break;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 9; i >= 0; --i) {
            while (hash[i] > 0) {
                res.append(i);
                hash[i]--;
            }
        }
        if(res.length() > 0 && res.charAt(0) == '0') {
            return "0";
        }
        return res.toString();
    }
}
