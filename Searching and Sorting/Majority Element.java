// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than n/2 times.


// Moore's Voting Algoritm
class Solution {
    public int majorityElement(int[] arr) {
        int n = arr.length;
        int x = arr[0];
        int count = 1;
        for(int i = 1; i < n; i++) {
            if(arr[i] == x) {
                count++;
            }
            else {
                count--;
            }
            if(count == 0) {
                x = arr[i];
                count = 1;
            }
        }
        count = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == x) {
                count++;
            }
        }
        if(count > n / 2) {
            return x;
        }
        return -1;
    }
}
