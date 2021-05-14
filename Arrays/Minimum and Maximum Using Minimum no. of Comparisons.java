// Return minimum and maximum in an array. 
// Your program should make the minimum number of comparisons. 

class Compute {
	// We just compare things in pairs. 
	// To make it work always, we need to find if number of elements are even or odd.
	// If even start from index 2, if odd start from index 1.
	// Then compare in pairs.
	// Total comparisons :
	// Even = 3n/2 - 2
	// Odd = 3*(n-1)/2
	
	// Linear search will do worst 2n - 3 comparisons, so this is way better.
    static pair getMinMax(long arr[], long n) {
        long min = 0;
        long max = 0;
        int i = 0;
        if(n % 2 == 0) {
            if(arr[0] > arr[1]) {
                max = arr[0];
                min = arr[1];
            }
            else {
                max = arr[1];
                min = arr[0];
            }
            i = 2;
        }
        else {
            min = arr[0];
            max = arr[0];
            i = 1;
        }
        while(i < n - 1) {
            if(arr[i] > arr[i + 1]) {
                if(arr[i] > max) {
                    max = arr[i];
                }
                if(arr[i + 1] < min) {
                    min = arr[i + 1];
                }
            }
            else {
                if(arr[i + 1] > max) {
                    max = arr[i + 1];
                }
                if(arr[i] < min) {
                    min = arr[i];
                }
            }
            i += 2;
        }
        pair p = new pair(min, max);
        return p;
    }
}
