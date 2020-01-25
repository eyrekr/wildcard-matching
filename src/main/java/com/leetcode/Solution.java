package com.leetcode;

public class Solution {

    public boolean isMatch(String input, String pattern) {
        int i = 0;
        int p = 0;
        int lastStarInPattern = -1;
        int returnToI = 0;

        while (i < input.length()) {
            if (p < pattern.length()
                    && (pattern.charAt(p) == '?' || pattern.charAt(p) == input.charAt(i))) {
                i++;
                p++;
            } else if (p < pattern.length() && pattern.charAt(p) == '*') {
                lastStarInPattern = p;
                returnToI = i;
                p++;
            } else if (lastStarInPattern != -1) {
                p = lastStarInPattern + 1;
                returnToI++;
                i = returnToI;
            } else {
                return false;
            }
        }

        while (p < pattern.length() && pattern.charAt(p) == '*') {
            p++;
        }

        return p == pattern.length();
    }
}
