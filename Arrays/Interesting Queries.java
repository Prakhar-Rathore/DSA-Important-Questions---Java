// Given an array nums of n elements and q queries . 
// Each query consists of two integers l and r . 
// You task is to find the number of elements of nums[]
// in range [l,r] which occur atleast k times.


// This is the classic Mo's Algorithm.
class Solution {
    static class Query {
        int l;
        int r;
        int i;
        Query(int l, int r, int i) {
            this.l = l;
            this.r = r;
            this.i = i;
        }
    }
    public int[] solveQueries(int[] arr, int[][] q, int k) {
        int n = arr.length;
        int m = q.length;
        int block = (int) Math.sqrt(n);
        ArrayList<Query> list = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            list.add(new Query(q[i][0] - 1, q[i][1] - 1, i));
        }
        list.sort((a, b) -> {
            if (a.l / block != b.l / block) {
                return (a.l < b.l ? -1 : 1);
            }
            return (a.r < b.r ? -1 : 1);
        });
        int[] res = new int[m];
        int[] hash = new int[1001];
        int cl = 0, cr = 0, count = 0;
        for(int i = 0; i < m; i++) {
            int l = list.get(i).l;
            int r = list.get(i).r;
            while(cl < l) {
                hash[arr[cl]]--;
                if(hash[arr[cl]] == k - 1) {
                    count--;
                }
                cl++;
            }
            while(cl > l) {
                hash[arr[cl - 1]]++;
                if(hash[arr[cl - 1]] == k) {
                    count++;
                }
                cl--;
            }

            while(cr <= r) {
                hash[arr[cr]]++;
                if(hash[arr[cr]] == k) {
                    count++;
                }
                cr++;
            }
            while(cr > r + 1) {
                hash[arr[cr - 1]]--;
                if(hash[arr[cr - 1]] == k - 1) {
                    count--;
                }
                cr--;
            }
            res[list.get(i).i] = count;
        }
        return res;
    }
}
