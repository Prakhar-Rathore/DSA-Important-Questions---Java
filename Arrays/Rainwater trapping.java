// Given an array arr[] of N non-negative integers representing the height of blocks. 
// If width of each block is 1, 
// compute how much water can be trapped between the blocks during the rainy season. 

// Case 1 - Using O(n) space
class Solution {
	// Very basic use of array preprocessing used to create left and right arrays.
    static int trappingWater(int arr[], int n) {
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = arr[0];
        for(int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }
        right[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            count += Math.min(left[i], right[i]) - arr[i];
        }
        return count;
    }
}

// Case 0 - Using O(1) space.
class Solution {
	// Tricky stuff, although intuitive, explanation here[https://youtu.be/m18Hntz4go8?t=558]
    static int trappingWater(int arr[], int n) {
        int l = 0;
        int r = n - 1;
        int res = 0;
        int leftmax = 0;
        int rightmax = 0;
        while(l <= r) {
            if(arr[l] <= arr[r]) {
                if(arr[l] >= leftmax) {
                    leftmax = arr[l];
                }
                else {
                    res += leftmax - arr[l];
                }
                l++;
            }
            else {
                if(arr[r] >= rightmax) {
                    rightmax = arr[r];
                }
                else {
                    res += rightmax - arr[r];
                }
                r--;
            }
        }
        return res;
    }
}
