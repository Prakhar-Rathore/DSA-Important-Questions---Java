// Given an array of integers nums containing n + 1 integers 
// where each integer is in the range [1, n] inclusive.
// There is only one repeated number in nums, return this repeated number.

class Solution {
	// Using hashing technique to find the result
	// This is a very naive approach, since it uses O(N) space.
    public int findDuplicate(int[] arr) {
        int n = arr.length;
        int[] hash = new int[n];
        for(int i = 0; i < n; i++) {
            if(hash[arr[i]] == 1) {
                return arr[i];
            }
            else {
                hash[arr[i]]++;
            }
        } 
        return -1;
    }
}


// A better technique is to use Floyds Cycle Detection algo
// Very tricky approach, revise using a yt video.

class Solution {
	// Using fast and slow pointers to find out the element
	// Crux is knowng that the element will be both inside the loop and outside the loop.
	// We just need to find it.
    public int findDuplicate(int[] arr) {
        int n = arr.length;
        int fast = arr[0];
        int slow = arr[0];
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while(slow != fast);
        slow = arr[0];
        while(slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return fast;
    }
}
