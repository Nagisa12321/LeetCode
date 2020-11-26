package com.leetcode.algorithm.No8;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ��������ʽ�ķ��������
 *
 * @������ʽ�� ����ο� https://www.runoob.com/java/java-regular-expressions.html
 ********* �÷�������ʱ�����********
 */
public class Solution3 {
    final int INT_MAX = (int) (Math.pow(2, 31) - 1);
    final int INT_MIN = (int) (-Math.pow(2, 31));

    public int myAtoi(String s) {
        String pattern = "^\\s*([-+]?\\d+)";
        Pattern thePattern = Pattern.compile(pattern);

        Matcher theMatcher = thePattern.matcher(s);
        if(!theMatcher.find())
            return 0;
        BigInteger theBigInteger = new BigInteger(theMatcher.group(1));
        if(theBigInteger.compareTo(new BigInteger(new String(INT_MAX + "")))>0)
            return INT_MAX;
        if(theBigInteger.compareTo(new BigInteger(new String(INT_MIN + "")))<0)
            return INT_MIN;
        return theBigInteger.intValue();
    }
}
