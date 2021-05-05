//Given an integer array arr and an integer k, modify the array by repeating it k times.
//Return the maximum sub-array sum in the modified array. 
//Note that the length of the sub-array can be 0 and its sum in that case is 0.
//As the answer can be very large, return the answer modulo 109 + 7.

import java.util.*;
public class Main {
    static long m = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(solution(arr, k));
        }
    }
    public static int solution(int[] arr,int k) {
    	//if k = 1 then no need of concatenation and answer will be just the kadane of the given array.
        if(k == 1) {
            return Math.max(kadane(arr), 0);
        }
        long sum = 0;
        for (int j : arr) {
            sum += j;
        }
        long res;
        // if sum < 0 then only the kadane of first concatenation will be maximum, can be understood using logic
        if(sum < 0) {
            res = kadaneTwo(arr);
        }
        // if sum > 0 then the kadane of first two will be added to the (k - 2) * total sum of array, cuz this will be the maximum sum
        else {
            res = kadaneTwo(arr) + ((k - 2) * sum);
        }
        return (int) Math.max(res % m, 0);
    }
    public static int kadane(int[] arr) {
        int sum = arr[0];
        int res = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(sum < 0) {
                sum = arr[i];
            }
            else {
                sum += arr[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
    public static int kadaneTwo(int[] arr) {
        int[] brr = new int[2 * arr.length];
        System.arraycopy(arr, 0, brr, 0, arr.length);
        System.arraycopy(arr, 0, brr, arr.length, arr.length);
        return kadane(brr);
    }
}
