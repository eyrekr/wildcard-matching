package com.leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({"adceb,*a*b,true", "aab,c*a*b,false", "mississippi,m??*ss*?i*pi,false", "acdcb,a*c?b,false", ",,true",
            ",*,true", "a,,false",
            "aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba,*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*,true"})
    void isMatch(String input, String pattern, boolean expectedAnswer) {
        if (input == null) {
            input = "";
        }
        if (pattern == null) {
            pattern = "";
        }
        final boolean actualAnswer = new Solution().isMatch(input, pattern);
        Assertions.assertThat(actualAnswer)
                .as("Expected '%s' matches '%s' to be %b but was %b", input, pattern, expectedAnswer, actualAnswer)
                .isEqualTo(expectedAnswer);
    }
}
