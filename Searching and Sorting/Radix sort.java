// This uses countSort to maintain the order of same elements.
// It works by comparing units digit, then ten's digit and so on.

public static void radixSort(int[] arr, int n) {
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < n; i++) {
        max = Math.max(arr[i], max);
    }
    int exp = 1;
    while(exp <= max) {
        countSort(arr, n, exp);
        exp *= 10;
    }
}

public static void countSort(int[] arr, int n, int exp) {
    int[] res = new int[n];
    int[] freq = new int[10];
    for(int i = 0; i < n; i++) {
        int index = arr[i] / exp % 10;
        freq[index]++;
    }
    for(int i = 1; i < 10; i++) {
        freq[i] += freq[i - 1];
    }
    for(int i = n - 1; i >= 0; i--) {
        int index = freq[arr[i] / exp % 10] - 1;
        res[index] = arr[i];
        freq[arr[i] / exp % 10]--;
    }
    for(int i = 0; i < n; i++) {
        arr[i] = res[i];
    }
}
