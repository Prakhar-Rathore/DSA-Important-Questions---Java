// Given two lists arr1 and arr2 of sizes n and m respectively. 
// Return the list of elements common to both the lists and return the list in sorted order. 
// Duplicates may be there in the output list.

// Using TreeMap to maintain the ascending order.
class Solution {
    public static ArrayList<Integer> common_element(ArrayList<Integer> arr1, 
                                                    ArrayList<Integer> arr2) {
        ArrayList<Integer> list = new ArrayList<>();
        TreeMap<Integer, Integer> hm1 = new TreeMap<>();
        for(int i : arr1) {
            if(hm1.containsKey(i)) {
                hm1.put(i, hm1.get(i) + 1);
            }
            else {
                hm1.put(i, 1);
            }
        }
        TreeMap<Integer, Integer> hm2 = new TreeMap<>();
        for(int i : arr2) {
            if(hm2.containsKey(i)) {
                hm2.put(i, hm2.get(i) + 1);
            }
            else {
                hm2.put(i, 1);
            }
        }
        for(Integer i : hm1.keySet()) {
            if(hm2.containsKey(i)) {
                int min = Math.min(hm1.get(i), hm2.get(i));
                while(min-- > 0) {
                    list.add(i);
                }
            }
        }
        return list;
    }
}
