// Given two arrays X and Y of positive integers, 
// find the number of pairs such that xy > yx (raised to power of) 
// where x is an element from X and y is an element from Y.


// Tricky stuff [https://youtu.be/LOBkPJU6g0k]
class Solution {
    static long countPairs(int arr1[], int arr2[], int n, int m) {
        Arrays.sort(arr2);
        Arrays.sort(arr1);
        long count = 0;
        long zero = 0, one = 0, two = 0, three = 0, four = 0;
        for(int i = 0; i < m; i++) {
            if(arr2[i] == 0) {
                zero++;
            }
            if(arr2[i] == 1) {
                one++;
            }
            if(arr2[i] == 2) {
                two++;
            }
            if(arr2[i] == 3) {
                three++;
            }
            if(arr2[i] == 4) {
                four++;
            }
        }
        for(int i = 0; i < n; i++) {
            if(arr1[i] == 0) {
                continue;
            }
            else if(arr1[i] == 1) {
                count += zero;
            }
            else if(arr1[i] == 2) {
                int index = binSearch(arr2, m, arr1[i]);
                if(index != -1) {
                    count += m - index;
                }
                count -= three;
                count -= four;
                count += one + zero;
            }
            else {
                int index = binSearch(arr2, m, arr1[i]);
                if(index != -1) {
                    count += m - index;
                }
                count += one + zero;
                if(arr1[i] == 3) {
                    count += two;
                }
            }
        }
        return count;
    }
    static int binSearch(int[] arr, int n, int x) {
        int l = 0;
        int h = n - 1;
        int res = -1;
        while(l <= h) {
            int mid = l + (h - l) / 2;
            if(arr[mid] > x) {
                res = mid;
                h = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return res;
    }
}
