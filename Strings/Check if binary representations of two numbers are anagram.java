// Given two numbers you are required to check whether 
// they are anagrams of each other or not in binary representation.


public static boolean checkIfBinaryAnagram(int a, int b) {
    int[] binary_a = new int[32];
    int[] binary_b = new int[32];
    int i = 0;
    while(a > 0) {
        binary_a[i++] = a % 2;
        a /= 2;
    }
    i = 0;
    while(b > 0) {
        binary_b[i++] = b % 2;
        b /= 2;
    }
    Arrays.sort(binary_a);
    Arrays.sort(binary_b);
    return Arrays.equals(binary_a, binary_b);
}
