// Given an array, print the reverse of it.

class Solution {
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
	 	while(t-- > 0) {
        	int n = sc.nextInt();
        	int[] arr = new int[n];
        	for(int i = 0; i < n; i++) {
        	    arr[i] = sc.nextInt();
        	}
        	reverse(arr);
        	for(int i = 0; i < n; i++) {
        	    System.out.print(arr[i] + " ");
        	}
        	System.out.println();
        }
	}
	// Simply using the two pointer approach and swapping to obtain the result.
	public static void reverse(int[] arr) {
	    int i = 0;
	    int j = arr.length - 1;
	    while(i < j) {
	        int temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	        i++;
	        j--;
	    }
	}
}
