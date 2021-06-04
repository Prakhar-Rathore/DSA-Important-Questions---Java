// Given a pattern containing only I's and D's. 
// I for increasing and D for decreasing.
// Devise an algorithm to print the minimum number following that pattern.
// Digits from 1-9 and digits can't repeat.

class Solution {
	// The crux of the problem lies in using Stack as the 
	// data structure and realising that the required
	// digit is somehow related to i of the loop.
    static String printMinNumberForPattern(String str) {
        int n = str.length();
        StringBuilder temp = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for(int i = 0; i <= n; i++) {
            stack.push(String.valueOf(i + 1));
            if(i == n || str.charAt(i) == 'I') {
                while(!stack.isEmpty()) {
                    temp.append(stack.pop());
                }
            }
        }
        return temp.toString();
    }
}

