//此方法利用翻转String，时间较长,内存也占用比较多！
public class Solution {
    public boolean isPalindrome(int x) {
        String theString = new String(x + "");
        StringBuilder theStringBuilder = new StringBuilder(theString);
        if (theStringBuilder.reverse().toString().equals(theString))
            return true;
        else
            return false;
    }
}
