// Given an array of distinct n integers. 
// The task is to check whether reversing one sub-array make the array sorted or not. 
// If the array is already sorted or by reversing a subarray once make it sorted, 
// print “Yes”, else print “No”.


// This method is O(nlogn). This can be done in better ways.
public static int solution(int[] arr, int n) {
    int[] temp = new int[n];
    for(int i = 0; i < n; i++) {
        temp[i] = arr[i];
    }
    Arrays.sort(temp);
    int l = 0;
    int h = n - 1;
    while(l < n && arr[l] == temp[l]) {
        l++;
    }
    if(l == n) {
        return 1;
    }
    while(h >=0 && arr[h] == temp[h]) {
        h--;
    }
    for(int i = l; i < h; i++) {
        if(arr[i] < arr[i + 1]) {
            return 0;
        }
    }
    return 1;
}


// This method is O(n).
public static boolean solution(int[] arr, int n) {
    if (n == 1) {
        return true;
    }
    int i;
    for (i = 1; arr[i - 1] < arr[i] && i < n; i++);
    if (i == n) {
        return true;
    }
    int j = i;
    while (j < n && arr[j] < arr[j - 1]) {
        if (i > 1 && arr[j] < arr[i - 2]) {
            return false;
        }
        j++;
    }
    if (j == n) {
        return true;
    }
    int k = j;
    if (arr[k] < arr[i - 1]) {
        return false;
    }
    while (k > 1 && k < n) {
        if (arr[k] < arr[k - 1]) {
            return false;
        }
        k++;
    }
    return true;
}
