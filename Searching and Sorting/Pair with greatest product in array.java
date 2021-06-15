// Given an array A of N elements. 
// The task is to find the greatest number S such that it is 
// product of two elements of given array 
// (S cannot be included in pair. Also, pair must be from different indices).


class Solution {
    public static int findGreatest(int arr[], int n) {
        Arrays.sort(arr);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i]) + 1);
            }
            else {
                hm.put(arr[i], 1);
            }
        }
        for(int i = n - 1; i >= 0; i--) {
            int x = arr[i];
            for(int j = 0; j < i && arr[j] <= Math.sqrt(x); j++) {
                int y = arr[j];
                if(x % y == 0 && y != 1) {
                    int res = x / y;
                    if (res != y && hm.containsKey(res)) {
                        return x;
                    }
                    else if (res == y && hm.get(res) > 1) {
                        return x;
                    }
                }
                if(y == 1 && hm.get(x) > 1) {
                    return x;
                }
            }
        }
        return -1;
    }
}
