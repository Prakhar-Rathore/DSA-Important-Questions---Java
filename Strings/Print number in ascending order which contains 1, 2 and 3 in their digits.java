// Given an array of numbers, 
// the task is to print those numbers in ascending order separated by commas which have 1, 2 and 3 in their digits. 
// If no number containing digits 1, 2, and 3 present then print -1.



public static int[] solution(int[] arr, int n) {
    ArrayList<Integer> list = new ArrayList<>();
    for(int i = 0; i < n; i++) {
        String s = String.valueOf(arr[i]);
        if(s.contains("1") && s.contains("2") && s.contains("3")) {
            list.add(Integer.parseInt(s));
        }
    }
    Collections.sort(list);
    int j = 0;
    int[] res = new int[list.size()];
    for(Integer i : list) {
        res[j++] = i;
    }
    return res;
}
