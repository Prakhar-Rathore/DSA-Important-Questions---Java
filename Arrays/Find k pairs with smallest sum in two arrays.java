// You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
// Define a pair (u, v) which consists of one element from the first array and one element from the second array.
// Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums1.length;
        int m = nums2.length;
        int[] index = new int[n];
        if(k > n * m) {
            k = n * m;
        }
        while(k-- > 0) {
            int minsum = Integer.MAX_VALUE;
            int mini = 0;
            
            for(int i = 0; i < n; i++) {
                if(index[i] < m && nums1[i] + nums2[index[i]] < minsum) {
                    mini = i;
                    minsum = nums1[i] + nums2[index[i]];
                }
            }
            
            List<Integer> temp = new ArrayList<>();
            temp.add(nums1[mini]);
            temp.add(nums2[index[mini]]);
            res.add(temp);
            index[mini]++;
        }
        return res;
    }
}
