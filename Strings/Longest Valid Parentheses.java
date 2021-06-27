// Given a string containing just the characters '(' and ')', 
// find the length of the longest valid (well-formed) parentheses substring.



class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int count = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            }
            else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                }
                else {
                    count = Math.max(count, i - stack.peek());
                }
            }
        }
        return count;
    }
}
