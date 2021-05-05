//Given an array A[ ] of positive integers of size N, 
//where each value represents the number of chocolates in a packet. 
//Each packet can have a variable number of chocolates. 
//There are M students, the task is to distribute chocolate packets among M students such that :
//1. Each student gets exactly one packet.
//2. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.

class Solution {
	//We just sort the array and find the window having the minimum diff
	//between its maximum and minimum element.
    public long findMinDiff(ArrayList<Long> list, long n, long m) {
        Collections.sort(list);
        long res = Integer.MAX_VALUE;
        for(int i = 0; i <= (int) n - m; i++) {
            res = Math.min((list.get(i + (int) m - 1) - list.get(i)), res);
        }
        return res;
    }
}
