// You are given an array arr[] of size n. 
// Find the total count of sub-arrays having their sum equal to 0.


class Solution {
    public static long findSubarray(long[] arr ,int n) {
        Map<Long, Long> hm = new HashMap<>();
        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            if(hm.containsKey(sum)) {
                hm.put(sum, hm.get(sum) + 1);
            }
            else {
                hm.put(sum, 1l);
            }
        }
        long count = 0;
        for(Long val : hm.keySet()) {
            long x = hm.get(val);
            if(val == 0) {
                count += x;
            }
            count += x * (x - 1) / 2;
        }
        return count;
    }
}
