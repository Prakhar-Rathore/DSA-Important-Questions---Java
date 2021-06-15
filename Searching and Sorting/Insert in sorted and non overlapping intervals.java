// Given a set of non-overlapping intervals and a new interval, 
// insert the interval at correct position. 
// If the insertion results in overlapping intervals, 
// then merge the overlapping intervals. 
// Assume that the set of non-overlapping intervals is sorted on the basis of start time, 
// to find correct position of insertion.


// Same logic of merge overlapping intervals
public static void solution(int[][] arr, int n, int[] toAdd) {
    Stack<int[]> stack = new Stack<>();
    stack.push(new int[] {arr[0][0], arr[0][1]});
    int[] top = stack.peek();
    if(toAdd[0] < top[1]) {
        stack.pop();
        top[0] = Math.min(top[0], toAdd[0]);
        top[1] = Math.max(top[1], toAdd[1]);
        stack.push(top);
    }
    else {
        stack.push(toAdd);
    }
    for(int i = 1; i < n; i++) {
        top = stack.peek();
        if(arr[i][0] < top[1]) {
            stack.pop();
            top[0] = Math.min(arr[i][0], top[0]);
            top[1] = Math.max(arr[i][1], top[1]);
            stack.push(top);
        }
        else{
            stack.push(new int[] {arr[i][0], arr[i][1]});
        }
    }
    int[][] res = new int[stack.size()][2];
    int m = stack.size();
    for(int i = 0; i < m; i++) {
        res[i][0] = stack.peek()[0];
        res[i][1] = stack.pop()[1];
    }
    for(int i = m - 1; i >= 0; i--) {
        System.out.println(res[i][0] + " " + res[i][1]);
    }
}
