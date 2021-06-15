// Given an array a[] of size N which contains elements from 0 to N-1, 
// you need to find all the elements occurring more than once 
// in the given array.

class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            arr[arr[i] % n] += n;
        }
        for(int i = 0; i < n; i++) {
            if(arr[i] / n > 1) {
                result.add(i);
            }
        }
        if(result.size() == 0) {
            result.add(-1);
        }
        return result;
    }
}

