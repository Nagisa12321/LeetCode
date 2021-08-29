package com.leetcode.algorithm.No71;

import java.util.Stack;

public class Solution2 {
    public String simplifyPath(String path) {
        Stack<String> theStack = new Stack<>();
        StringBuilder theBuilder = new StringBuilder("");
        for(int i = 0;i < path.length();i++){
            if(path.charAt(i) == '/'){
                if(theBuilder.toString().equals("..")){
                    if(!theStack.isEmpty())
                        theStack.pop();
                }else if(!theBuilder.toString().equals(".")&&!theBuilder.toString().equals("")){
                    theStack.push(theBuilder.toString());
                }
                theBuilder = new StringBuilder("");
            }else{
                theBuilder.append(path.charAt(i));
            }
        }
        if(theBuilder.toString().equals("..")){
            if(!theStack.isEmpty())
                theStack.pop();
        }else if(!theBuilder.toString().equals(".")&&!theBuilder.toString().equals("")){
            theStack.push(theBuilder.toString());
        }
        if(theStack.isEmpty()){
            return "/";
        }
        theBuilder = new StringBuilder("");
        for(int i = 0;i < theStack.size();i++){
            theBuilder.append("/" + theStack.get(i));
        }
        return theBuilder.toString();
    }
}
