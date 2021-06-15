// this algo also preserves the relative order of same elements.
// It is stable.

public static void countSort(int[] arr, int n) {
    int[] res = new int[n];
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < n; i++) {
        min = Math.min(arr[i], min);
        max = Math.max(arr[i], max);
    }
    int range = max - min + 1;
    int[] freq = new int[range];
    for(int i = 0; i < n; i++) {
        int index = arr[i] - min;
        freq[index]++;
    }
    for(int i = 1; i < range; i++) {
        freq[i] += freq[i - 1];
    }
    for(int i = n - 1; i >= 0; i--) {
        int element = arr[i];
        int index = freq[element - min] - 1;
        res[index] = element;
        freq[element - min]--;
    }
    for(int i = 0; i < n; i++) {
        arr[i] = res[i];
    }
}
