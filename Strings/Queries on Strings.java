// Given a string str you have to answer several queries on that string. 
// In each query you will be provided two values L and R and you have to find the number of distinct characters 
// in the sub string from index L to index R (inclusive) of the original string.



class Solution {
    public int[] SolveQueris(String str, int[][] queries) {
        int n = str.length();
        int m = queries.length;
        int[] res = new int[m];
        for(int i = 0; i < m; i++) {
            Set<Character> set = new HashSet<>();
            int l = queries[i][0] - 1;
            int h = queries[i][1];
            for(int j = l; j < h; j++) {
                set.add(str.charAt(j));
            }
            res[i] = set.size();
        }
        return res;
    }
}
