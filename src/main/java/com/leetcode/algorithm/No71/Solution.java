package com.leetcode.algorithm.No71;

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> theStack = new Stack<>();
        StringBuilder theBuilder = new StringBuilder("");
        StringBuilder theBuilder2 = new StringBuilder("");
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                if (!theBuilder.toString().equals("")) {
                    theStack.push(theBuilder.toString());
                    theBuilder = new StringBuilder("");
                }
                if (!theBuilder2.toString().equals("")) {
                    if (theBuilder2.length() % 2 == 1 && theBuilder2.length() != 1) {
                        theStack.push(theBuilder2.toString());
                        theBuilder2 = new StringBuilder("");
                    } else if (!theStack.isEmpty() && theBuilder2.length() != 1) {
                        theStack.pop();
                        theBuilder2 = new StringBuilder("");
                    } else theBuilder2 = new StringBuilder("");
                }
            } else if (path.charAt(i) == '.') {
                theBuilder2.append(".");
            } else {
                theBuilder.append(path.charAt(i));
            }
        }
        if (!theBuilder.toString().equals("")) {
            theStack.push(theBuilder.toString());
        }
        if (!theBuilder2.toString().equals("")) {
            if (theBuilder2.length() % 2 == 1 && theBuilder2.length() != 1) {
                theStack.push(theBuilder2.toString());
            } else if (!theStack.isEmpty() && theBuilder2.length() != 1) {
                theStack.pop();
            }
        }
        if (theStack.isEmpty()) return "/";
        theBuilder = new StringBuilder();
        int i = 0;
        while (!theStack.isEmpty()) {
            theBuilder.append("/" + theStack.get(i));

        }
        return theBuilder.reverse().toString();
    }
}
