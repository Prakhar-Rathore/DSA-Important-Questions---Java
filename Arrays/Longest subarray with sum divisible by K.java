// Given an array containing N integers and a positive integer K, 
// find the length of the longest sub array with 
// sum of the elements divisible by the given value K

class Solution {
    int longSubarrWthSumDivByK(int arr[], int n, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int res = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            int temp = ((sum % k) + k) % k; // most imp (handles negative modulus)
            if(temp == 0) {
                res = Math.max(res, i + 1);
            }
            if(!hm.containsKey(temp)) {
                hm.put(temp, i);
            }
            else {
                res = Math.max(res, i - hm.get(temp));
            }
        }
        return res;
    }
}
