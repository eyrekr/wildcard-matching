package com.leetcode;

public class Solution {

    public boolean isMatch(String input, String pattern) {
        final int n = input.length();

        boolean[] matches = new boolean[n + 1];
        matches[0] = true;
        boolean asterisk = false;
        int liveZone = 0;

        for (int k = 0; k < pattern.length(); k++) {
            char p = pattern.charAt(k);
            if (p == '*') {
                asterisk = true;
            } else {
                final int stop = liveZone;
                liveZone = Integer.MAX_VALUE;
                for (int i = n; i > stop; i--) {
                    final boolean match = (asterisk || matches[i - 1])
                            && (p == '?' || p == input.charAt(i - 1));
                    matches[i] = match;
                    if (match) {
                        liveZone = i;
                    }
                }
                asterisk = false;
                if (liveZone == Integer.MAX_VALUE) {
                    return false;
                }
            }
        }

        return matches[n] || asterisk;
    }
}
