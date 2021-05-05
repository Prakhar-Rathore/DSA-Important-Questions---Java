//Given an array Arr[] of size n and a number diff, 
//you need to write a program to find,
//if there exists a pair of elements in the array whose difference is diff.

class Solution {
	//First we sort the array to make the elements in order for the two pointers.
	//We use a different two pointer approach where we start both the pointers from the start
	//This is because the normal two pointer approach wont work in this case.
    public boolean findPair(int arr[], int n, int diff) {
        Arrays.sort(arr);
        int l = 0;
        int h = 1;
        while(l < n && h < n) {
            if(l != h && arr[h] - arr[l] == diff) {
                return true;
            }
            else if(arr[h] - arr[l] > diff) {
                l++;
            }
            else {
                h++;
            }
        }
        return false;
    }
}
