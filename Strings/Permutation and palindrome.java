// You are given a string s with length n. 
// You should find a permutation P of numbers 1 through n such that 
// if you apply this permutation on the string s, you will get a palindromic string.
// The result of applying a permutation P on the string s is a string t with 
// length n such that for each i (1 ≤ i ≤ n), 
// the i-th character of t is given as as t[i] = s[Pi].



public static int[] solution(String s, int n) {
    HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
    for(int i = 0; i < n; i++) {
        char c = s.charAt(i);
        if(map.containsKey(c)) {
            map.get(c).add(i + 1);
        }
        else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i + 1);
            map.put(c, list);
        }
    }
    int odd = 0;
    for(Character c : map.keySet()) {
        if(map.get(c).size() % 2 != 0) {
            odd++;
        }
    }
    if (odd > 1) return new int[] {-1};
    if(odd == 1 && n % 2 == 0) return new int[] {-1};
    if(odd == 0 && n % 2 == 1) return new int[] {-1};

    int l = 0;
    int h = n - 1;
    int[] res = new int[n];
    for(int i = 0; i < n; i++) {
        char c = s.charAt(i);
        if(!map.containsKey(c)) {
            continue;
        }
        ArrayList<Integer> list = map.get(c);
        int k = 0;
        if(list.size() % 2 == 0) {
            while(k < list.size()) {
                res[l++] = list.get(k++);
                res[h--] = list.get(k++);
            }
            map.remove(c);
        }
    }
    for(Character c : map.keySet()) {
        ArrayList<Integer> list = map.get(c);
        int k = 0;
        while(k < list.size()) {
            res[l++] = list.get(k++);
        }
        map.remove(c);
    }
    return res;
}
