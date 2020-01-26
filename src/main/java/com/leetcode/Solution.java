package com.leetcode;

public class Solution {

    public boolean isMatch(String input, String pattern) {
        final int n = input.length();

        final byte[] matches = new byte[n + 1];
        matches[0] = 1;
        byte asterisk = 0;
        int liveZone = 0;

        for (int k = 0; k < pattern.length(); k++) {
            char p = pattern.charAt(k);
            if (p == '*') {
                asterisk = 1;
            } else {
                final int stop = liveZone;
                liveZone = Integer.MAX_VALUE;
                for (int i = n; i > stop; i--) {
                    final byte match = (byte) (asterisk | matches[i - 1]);
                    if (match == 1 && (p == '?' || p == input.charAt(i - 1))) {
                        matches[i] = 1;
                        liveZone = i;
                    } else {
                        matches[i] = 0;
                    }
                }
                asterisk = 0;
                if (liveZone == Integer.MAX_VALUE) {
                    return false;
                }
            }
        }

        return (matches[n] | asterisk) == 1;
    }
}
