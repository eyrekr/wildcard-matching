package com.leetcode;

import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    @ParameterizedTest
    @MethodSource
    void isMatch(String input, String pattern, boolean expectedAnswer) {
        final boolean actualAnswer = new Solution().isMatch(input, pattern);
        Assertions.assertThat(actualAnswer)
                .as("'%s' should %s '%s' but it %s",
                        input,
                        expectedAnswer ? "match" : "not match",
                        pattern,
                        actualAnswer ? "did" : "didn't")
                .isEqualTo(expectedAnswer);
    }

    private static Stream<Arguments> isMatch() {
        return Stream.of(
                Arguments.of("adceb", "*a*b", true),
                Arguments.of("aab", "c*a*b", false),
                Arguments.of("mississippi", "m??*ss*?i*pi", false),
                Arguments.of("acdcb", "a*c?b", false),
                Arguments.of("", "", true),
                Arguments.of("", "*", true),
                Arguments.of("", "a", false),
                Arguments.of("axxxxxaxxxxxa", "a*a", true),
                Arguments.of(
                        "aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba",
                        "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*",
                        true));
    }
}
