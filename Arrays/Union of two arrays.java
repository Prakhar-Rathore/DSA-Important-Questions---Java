// Given two arrays a[] and b[] of size n and m respectively. 
// The task is to find union between these two arrays.
// Union of the two arrays can be defined as the set containing 
// distinct elements from both the arrays. 
// If there are repetitions, then only one occurrence of element should be printed in union.

class Solution {
	// The most basic use of sets.
    public static int doUnion(int a[], int n, int b[], int m) {
        Set<Integer> hs = new HashSet<>();
        for(int i = 0; i < n; i++) {
            hs.add(a[i]);
        }
        for(int i = 0; i < m; i++) {
            hs.add(b[i]);
        }
        return hs.size();
    }
}
