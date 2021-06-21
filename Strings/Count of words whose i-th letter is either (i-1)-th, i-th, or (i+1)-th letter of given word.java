// Given a string str. 
// The task is to count the words having the same length as str and each letter at the i-th position is either (i-1)-th, i-th, or (i+1)-th position letter of str.
// Note: For the first letter consider i-th and (i+1)-th position letter of W. 
// And for last letter consider (i-1)-th and i-th position letter of str.


// Crux is to know the total possibilities of each letter.
public static int solution(String str) {
    int n = str.length();
    if(n == 1) {
        return 1;
    }
    int count = 1;
    for(int i = 1; i < n - 1; i++) {
        char a = str.charAt(i - 1);
        char b = str.charAt(i);
        char c = str.charAt(i + 1);
        if(a == b && b == c) {
            count *= 1;
        }
        else if(a == b || b == c || a == c) {
            count *= 2;
        }
        else {
            count *= 3;
        }
    }
    if(str.charAt(0) != str.charAt(1)) {
        count *= 2;
    }
    if(str.charAt(n - 2) != str.charAt(n - 1)) {
        count *= 2;
    }
    return count;
}
