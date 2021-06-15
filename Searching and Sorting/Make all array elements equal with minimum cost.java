// Given an array which contains integer values, 
// we need to make all values of this array equal to some integer value 
// with minimum cost where the cost of changing an array value 
// x to y is abs(x-y). 

public static void main(String[] args) {
    FastReader sc = new FastReader();
    PrintWriter out = new PrintWriter(System.out);
    int[] arr = {4, 6};
    int n = 2;
    out.println(solution(arr, n));
    out.flush();
    out.close();
}
// Minimum cost will be when we try to make all elements equal to the 
// median of the array.
public static int solution(int[] arr, int n) {
    Arrays.sort(arr);
    int x;
    if(n % 2 == 0) {
        x = (arr[n / 2] + arr[(n / 2) - 1]) / 2;
    }
    else {
        x = arr[n / 2];
    }
    int cost = 0;
    for(int i = 0; i < n; i++) {
        cost += Math.abs(arr[i] - x);
    }
    return cost;
}
