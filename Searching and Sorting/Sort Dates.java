// Given a big list of dates in ’20s, 
// how to efficiently sort the list. 

// This technique uses radix sort
public static void main(String[] args) {
    FastReader sc = new FastReader();
    PrintWriter out = new PrintWriter(System.out);
    int[][] arr = {{20,  1, 2014},
            {25,  3, 2010},
            { 3, 12, 2000},
            {18, 11, 2000},
            {19,  4, 2015},
            { 9,  7, 2005}};
    int n = arr.length;
    sortDates(arr, n, 0);
    sortDates(arr, n, 1);
    sortDates(arr, n, 2);
    out.println(Arrays.deepToString(arr));
    out.flush();
    out.close();
}
public static void sortDates(int[][] arr, int n, int x) {
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < n; i++) {
        max = Math.max(max, arr[i][x]);
    }
    int exp = 1;
    while(max > 0) {
        int[] freq = new int[10];
        for(int i = 0; i < n; i++) {
            freq[arr[i][x] / exp % 10]++;
        }
        for(int i = 1; i < 10; i++) {
            freq[i] += freq[i - 1];
        }
        int[][] res = new int[n][3];
        for(int i = n - 1; i >= 0; i--) {
            int element = arr[i][x] / exp % 10;
            for(int j = 0; j < 3; j++) {
                res[freq[element] - 1][j] = arr[i][j];
            }
            freq[element]--;
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                arr[i][j] = res[i][j];
            }
        }
        exp *= 10;
        max /= 10;
    }
}
