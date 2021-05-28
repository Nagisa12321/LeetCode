package com.leetcode.algorithm.No567;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/22 11:44
 */
public class Solution2 {
    /* Rolling Hash */
    public boolean checkInclusion(String s1, String s2) {
        char[] chs_s1 = s1.toCharArray();
        char[] chs_s2 = s2.toCharArray();
        if (chs_s1.length > chs_s2.length) return false;

        int len = chs_s1.length;
        // s1��hashCode
        // �����ʼ���ڵ�codeֵ
        int hashCode = 0;
        int code = 0;
        // ��ֹ�ظ���ȡ����
        int chs_s1_i;
        int chs_s2_i;

        for (int i = 0; i < len; i++) {
            chs_s1_i = chs_s1[i];
            chs_s2_i = chs_s2[i];


            hashCode += chs_s1_i * chs_s1_i;
            code += chs_s2_i * chs_s2_i;
        }

        // ��ֹ�ظ���ȡ����
        int chs_s2_a;
        int chs_s2_b;
        for (int i = 0; i <= chs_s2.length - len; i++) {
            if (i > 0) {
                chs_s2_a = chs_s2[i - 1];
                chs_s2_b = chs_s2[i + len - 1];

                code -= chs_s2_a * chs_s2_a;
                code += chs_s2_b * chs_s2_b;
            }
            if (code == hashCode) return true;
        }
        return false;
    }
}