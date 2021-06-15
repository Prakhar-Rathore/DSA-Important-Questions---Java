// Given an array, 
// print all subarrays in the array which has sum 0.

static class Pair {
    int first, second;
    Pair(int a, int b) {
        first = a;
        second = b;
    }
}
public static ArrayList<Pair> solution(int[] arr, int n) {
    HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
    ArrayList<Pair> res = new ArrayList<>();
    int sum = 0;
    for(int i = 0; i < n; i++) {
        sum += arr[i];
        if(sum == 0) {
            res.add(new Pair(0, i));
        }
        ArrayList<Integer> temp = new ArrayList<>();
        if(hm.containsKey(sum)) {
            temp = hm.get(sum);
            for(Integer val : temp) {
                res.add(new Pair(val + 1, i));
            }
        }
        temp.add(i);
        hm.put(sum, temp);
    }
    return res;
}
