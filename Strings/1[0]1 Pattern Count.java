// Given a string S, 
// your task is to find the number of patterns of form 1[0]1 
// where [0] represents any number of zeroes (minimum requirement is one 0),
// there should not be any other character except 0 in the [0] sequence.



class Solution {
    int patternCount(String s) {
        int n = s.length();
        int count = 0;
        for(int i = 0; i < n;) {
            char c = s.charAt(i);
            boolean flag = false;
            if(i < n - 1 && c == '1' && s.charAt(i + 1) == '0') {
                i++;
                while(i < n && s.charAt(i) == '0') {
                    i++;
                }
                if(i < n && s.charAt(i) == '1') {
                    count++;
                }
                flag = true;
            }
            if(!flag) i++;
        }
        return count;
    }
} 
