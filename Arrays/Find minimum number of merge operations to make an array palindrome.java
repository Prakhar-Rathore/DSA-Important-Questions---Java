// Given an array of positive integers. 
// We need to make the given array a ‘Palindrome’. 
// The only allowed operation is”merging” (of two adjacent elements). 
// Merging two adjacent elements means replacing them with their sum. 
// The task is to find the minimum number of merge operations required to make the given array a ‘Palindrome’.

class Solution {
	// Using the simple two pointer approach
	static int solution(int[] arr, int n) {
        int l = 0;
        int h = n - 1;
        int res = 0;
        while(l < h) {
            if(arr[l] == arr[h]) {
                l++;
                h--;
            }
            else if(arr[l] > arr[h]) {
                h--;
                arr[h] += arr[h + 1];
                res++;
            }
            else {
                l++;
                arr[l] += arr[l - 1];
                res++;
            }
        }
        return res;
    }
}
