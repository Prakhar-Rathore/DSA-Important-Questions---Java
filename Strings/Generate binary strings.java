// Given a string containing of ‘0’, ‘1’ and ‘?’ - a wildcard character, 
//generate all distinct binary strings that can be formed by 
// replacing each wildcard character by either ‘0’ or ‘1’.


// Recursion is used 
class Solution {
    List<String> res;
    public List<String> generate_binary_string(String s) {
        res = new ArrayList<>();
        gen(s);
        return res;
    }
    public void gen(String str) {
        if(str.contains("?")) {
            String s1 = str.replaceFirst("\\?", "0");
            String s2 = str.replaceFirst("\\?", "1");
            gen(s1);
            gen(s2);
        }
        else {
            res.add(str);
        }
    }
}
