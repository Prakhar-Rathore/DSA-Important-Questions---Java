// Given two sorted arrays nums1 and nums2 of size m and n respectively, 
// return the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n))

// Very tricky stuff [https://youtu.be/jDJuW7tSxio]
class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        if(arr1.length > arr2.length) {
            int[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        int n = arr1.length;
        int m = arr2.length;
        if(n == 0) {
            return find(arr2);
        }
        int total = n + m;
        int l = 0;
        int h = n;
        double res = 0.0;
        while(l <= h) {
            int ia = l + (h - l) / 2;
            int ib = (total + 1) / 2 - ia;

            int am1 = (ia == 0) ? Integer.MIN_VALUE : arr1[ia - 1];
            int a = (ia == n) ? Integer.MAX_VALUE : arr1[ia];
            int bm1 = (ib == 0) ? Integer.MIN_VALUE : arr2[ib - 1];
            int b = (ib == m) ? Integer.MAX_VALUE : arr2[ib];

            if(am1 <= b && bm1 <= a) {
                if(total % 2 == 0) {
                    int lm = Math.max(am1, bm1);
                    int rm = Math.min(a, b);
                    res = (lm + rm) / 2.0;
                }
                else {
                    res = Math.max(am1, bm1);
                }
                return res;
            }
            else if(am1 > b) {
                h = ia - 1;
            }
            else if(bm1 > a){
                l = ia + 1;
            }
        }
        return res;
    }
    public double find(int[] arr) {
        int n = arr.length;
        if(n % 2 == 0) {
            return (arr[n / 2] + arr[n / 2 - 1]) / 2.0;
        }
        else {
            return arr[n / 2];
        }
    }
}
