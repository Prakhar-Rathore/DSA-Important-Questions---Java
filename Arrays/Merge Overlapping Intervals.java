// Given an array of intervals where intervals[i] = [starti, endi], 
// merge all overlapping intervals, 
// and return an array of the non-overlapping intervals 
// that cover all the intervals in the input.

class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {arr[0][0], arr[0][1]});
        for(int i = 1; i < arr.length; i++) {
            int[] temp = {arr[i][0], arr[i][1]};
            if(temp[0] <= stack.peek()[1]) {
                int[] top = stack.pop();
                top[1] = Math.max(temp[1], top[1]);
                stack.push(top);
            }
            else {
                stack.push(temp);
            }
        }
        int[][] res = new int[stack.size()][2];
        int n = stack.size();
        for(int i = 0; i < n; i++) {
            int[] temp = stack.pop();
            res[i][0] = temp[0];
            res[i][1] = temp[1];
        }
        Arrays.sort(res, Comparator.comparingInt(a -> a[0]));
        return res;
    }
}
