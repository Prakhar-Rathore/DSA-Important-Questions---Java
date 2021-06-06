// Given a list of non negative integers, 
// arrange them in such a manner that they form the largest number possible.
// The result is going to be very large, 
// hence return the result in the form of a string.

class Solution {
	// The crux of the question is to use the comparator.
    String printLargest(String[] str) {
        Arrays.sort(str, (a, b) -> {
            String ab = a + b;
            String ba = b + a;
            return Integer.compare(0, ab.compareTo(ba));
        });
        StringBuilder res = new StringBuilder();
        for(String s : str) {
            res.append(s);
        }
        return res.toString();
    }
}
