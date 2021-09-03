// Given arrival and departure times of all trains that reach a railway station. 
// Find the minimum number of platforms required for the railway station so that no train is kept waiting.
// Consider that all the trains arrive on the same day and leave on the same day. 
// Arrival and departure time can never be the same for a train 
// but we can have arrival time of one train equal to departure time of the other. 
// At any given instance of time, 
// same platform can not be used for both departure of a train and arrival of another train. 
// In such cases, we need different platforms,

class Solution {
	// Very basic use of stack type count variable, we just need to keep increasing
	// count variable when trains keep stacking i.e. (the arrival array[i] < departure array[i])
	// since the arrays are sorted we are guaranteed that dep[i] is the smallest at any given iteration and
	// all the greater elements are on the right of it.
    static int findPlatform(int arr[], int dep[], int n) {
        int count = 0;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0;
        int j = 0;
        int res = 0;
        while(i < n && j < n) {
        	// in this if statement, the equal sign denotes that, if arrival and departure times are same
        	// for any two different trains, we need two platforms for that.
            if(arr[i] <= dep[j]) {
                count++;
                i++;
            }
            else {
                count--;
                j++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}

// Most optimal way to solve this usin
// O(n) time and O(n) space
class Solution {
    static int findPlatform(int at[], int dt[], int n) {
        int[] hash = new int[2400];
        for(int i : at) hash[i]++;
        for(int i : dt) hash[i + 1]--;
        int res = hash[0];
        for(int i = 1; i < 2360; i++) {
            hash[i] += hash[i - 1];
            res = Math.max(hash[i], res);
        }
        return res;
    }
}
