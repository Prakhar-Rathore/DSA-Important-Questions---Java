// Stickler the thief wants to loot money from a society having n houses in a single line. 
// He is a weird person and follows a certain rule when looting the houses. 
// According to the rule, he will never loot two consecutive houses. 
// At the same time, he wants to maximize the amount he loots. 
// The thief knows which house has what amount of money but is unable to come up with an optimal looting strategy. 
// He asks for your help to find the maximum money he can get if he strictly follows the rule. 
// Each house has a[i] amount of money present in it.

// Classic dp problem, theif has two choices, to steal the current one and add prev2 to it.
// Or the thief can leave this house, and we just update the prevs.
class Solution {
    public int rob(int[] arr) {
        int prev1 = 0;
        int prev2 = 0;
        for(int money : arr) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + money);
            prev2 = temp;
        }
        return prev1;
    }
}
