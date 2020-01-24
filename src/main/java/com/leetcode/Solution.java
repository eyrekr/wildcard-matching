package com.leetcode;

public class Solution {

    public boolean isMatch(String input, String pattern) {
        final int n = input.length();

        boolean[] data = new boolean[n + 1];
        data[0] = true;

        for (int k = 0; k < pattern.length(); k++) {
            char p = pattern.charAt(k);
            boolean atLeastOneMatches = false;
            if (p == '*') {
                for (int i = 0; i <= n; i++) {
                    data[i] = atLeastOneMatches || data[i];
                    atLeastOneMatches |= data[i];
                }
            } else {
                boolean prev = data[0];
                for (int i = 1; i <= n; i++) {
                    final boolean matches = prev && (p == '?' || p == input.charAt(i - 1));
                    prev = data[i];
                    data[i] = matches;
                    atLeastOneMatches |= matches;
                }
                data[0] = false;
            }
            if (!atLeastOneMatches) {
                return false;
            }
        }

        return data[n];
    }
}
