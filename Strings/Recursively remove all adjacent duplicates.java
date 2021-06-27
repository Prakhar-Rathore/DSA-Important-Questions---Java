// Given a string S delete the characters which are appearing more than once consecutively.



class Solution{
    public String removeConsecutiveCharacter(String s){
        if(s.length() < 2) {
            return s;
        }
        char c = s.charAt(0);
        String res = removeConsecutiveCharacter(s.substring(1));
        if(c == res.charAt(0)) {
            return res;
        }
        return c + res;
    }
}
