public class Solution2 {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int theNewx = 0;
        int theOldx = x;
        while (theOldx != 0) {
            int temp = theOldx % 10;
            theNewx = 10 * theNewx + temp;
            theOldx /= 10;
        }
        if (theNewx == x)
            return true;
        else return false;
    }
}
