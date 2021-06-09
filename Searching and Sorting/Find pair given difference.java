// Given an array Arr[] of size L and a number N, 
// you need to write a program to find if there exists a pair 
// of elements in the array whose difference is N.

// The usual two pointer approach wont work, because l++ and h--
// both will reduce the diff, so we start both the pointers
// from the start.
class Solution {
    public boolean findPair(int arr[], int n, int diff) {
        Arrays.sort(arr);
        int l = 0;
        int h = 1;
        while(l < n && h < n) {
            if(arr[h] - arr[l] == diff) {
                return true;
            }
            else if(arr[h] - arr[l] < diff) {
                h++;
            }
            else {
                l++;
            }
        }
        return false;
    }
}
