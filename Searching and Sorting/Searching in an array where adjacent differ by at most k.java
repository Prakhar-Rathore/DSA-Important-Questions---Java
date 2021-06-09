// A step array is an array of integer 
// where each element has a difference of at most k with its neighbor. 
// Given a key x, we need to find the index value of k if multiple elements exist, 
// return the first occurrence of the key.

// The crux is to increase by diff / k  each time instead of 1
class Complete {
    public static int search (int arr[], int n, int x, int k) {
        for(int i = 0; i < n;) {
            if(arr[i] == x) {
                return i;
            }
            int inc = Math.abs(arr[i] - x) / k;
            if(inc > 0) {
                i += inc;
            }
            else {
                i++;
            }
        }
        return -1;
    }
}

