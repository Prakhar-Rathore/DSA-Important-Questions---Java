// Given an array of integers, 
// sort the array (in descending order) according to count of set bits 
// in binary representation of array elements. 
// Note: For integers having same number of set bits in their binary representation, 
// sort according to their position in the original array i.e., a stable sort.


// The crux of the question was to use a comparator and use Kernighn's Algorithm
class Compute {
    static void sortBySetBitCount(Integer arr[], int n) {
        Arrays.sort(arr, (a, b) -> {
            int count1 = 0;
            int count2 = 0;
            int x = a;
            while(x != 0) {
                int temp = x & -x;
                x -= temp;
                count1++;
            }
            x = b;
            while(x != 0) {
                int temp = x & -x;
                x -= temp;
                count2++;
            }
            if(count1 > count2) {
                return -1;
            }
            else if(count1 < count2) {
                return 1;
            }
            return 0;
        });
    } 
}
