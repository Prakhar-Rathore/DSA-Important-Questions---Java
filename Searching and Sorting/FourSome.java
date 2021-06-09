// Given an array of integers and another number. 
// Find all the unique quadruple from the given array that sums up to the given number.

// Case 1 - Order is important (lexicographical)
// Time - O(n^3)
// Space - O(n^2)
class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int sum) {
        Arrays.sort(arr);
        int n = arr.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) {
                    continue;
                }
                int l = j + 1;
                int h = n - 1; 
                while (l < h) {
                    int old_l = l;
                    int old_r = h;
                    if (arr[i] + arr[j] + arr[l] + arr[h] == sum) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[l]);
                        temp.add(arr[h]);
                        res.add(temp);

                        while (l < h && arr[l] == arr[old_l]) l++;
                        while (l < h && arr[h] == arr[old_r]) h--;
                    }
                    else if (arr[i] + arr[j] + arr[l] + arr[h] < sum)
                        l++;
                    else 
                        h--;
                }
            }
        }
        return res;
    }
}

// Case 1 - Order is not important (lexicographical)
// Time - O(n^2)
// Space - O(n^2)
public List<List<Integer>> fourSum(int[] arr, int target) {
        Set<List<Integer>> res = new HashSet<>();
        int n = arr.length;

        Map<Integer, Set<List<Integer>>> sum2Nums = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                sum2Nums.computeIfAbsent(arr[i] + arr[j], k -> new HashSet<>()).add(Arrays.asList(i, j));
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int s = target - (arr[i] + arr[j]);
                if (sum2Nums.containsKey(s)) {
                    for (List<Integer> kl : sum2Nums.get(s)) {
                        if (kl.get(0) > j && kl.get(1) > j) {
                            List<Integer> quad = Arrays.asList(arr[i], arr[j], arr[kl.get(0)], arr[kl.get(1)]);
                            Collections.sort(quad);
                            res.add(quad);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }
