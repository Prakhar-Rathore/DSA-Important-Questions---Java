// Given two integer arrays nums1 and nums2, 
// return an array of their intersection. 
// Each element in the result must be unique and you may return the result in any order.



class Solution {
	// Simple use of sets again
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hs = new HashSet<>();
        for(int i = 0; i < nums1.length; i++) {
            hs.add(nums1[i]);
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums2.length; i++) {
            if(hs.contains(nums2[i])) {
                list.add(nums2[i]);
                hs.remove(nums2[i]);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
