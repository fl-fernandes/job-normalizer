package com.normalizer.job_normalizer.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NormalizerUtilTest {
  @Test
  void testLevenshteinDistance_whenTargetWordIsLonger() {
    final String sourceWord = "java engineer";
    final String targetWord = "software engineer";
    final Integer expectedLevenshteinDistance = 7;

    Integer levenshteinDistance = NormalizerUtil.levenshteinDistance(sourceWord, targetWord);
  
    assertEquals(expectedLevenshteinDistance, levenshteinDistance);
  }

  @Test
  void testLevenshteinDistance_whenTargetWordIsShorter() {
    final String sourceWord = "software engineer";
    final String targetWord = "java engineer";
    final Integer expectedLevenshteinDistance = 7;

    Integer levenshteinDistance = NormalizerUtil.levenshteinDistance(sourceWord, targetWord);

    assertEquals(expectedLevenshteinDistance, levenshteinDistance);
  }

  @Test
  void testLevenshteinDistance_whenWordsHaveDifferentCasing() {
    final String sourceWord = "SoFtWaRe EnGiNeeR";
    final String targetWord = "java engineer";
    final Integer expectedLevenshteinDistance = 11;

    Integer levenshteinDistance = NormalizerUtil.levenshteinDistance(sourceWord, targetWord);

    assertEquals(expectedLevenshteinDistance, levenshteinDistance);
  }

  @Test
  void testLevenshteinDistance_whenWordsAreEqual() {
    final String sourceWord = "software engineer";
    final String targetWord = "software engineer";
    final Integer expectedLevenshteinDistance = 0;

    Integer levenshteinDistance = NormalizerUtil.levenshteinDistance(sourceWord, targetWord);

    assertEquals(expectedLevenshteinDistance, levenshteinDistance);
  }

  @Test
  void testLevenshteinDistance_whenWordsAreEqualButDifferentCasing() {
    final String sourceWord = "SoFtWaRe EnGiNeeR";
    final String targetWord = "software engineer";
    final Integer expectedLevenshteinDistance = 8;

    Integer levenshteinDistance = NormalizerUtil.levenshteinDistance(sourceWord, targetWord);

    assertEquals(expectedLevenshteinDistance, levenshteinDistance);
  }

  @Test
  void testLevenshteinDistance_whenBothWordsAreEmpty() {
    final String sourceWord = "";
    final String targetWord = "";
    final Integer expectedLevenshteinDistance = 0;

    Integer levenshteinDistance = NormalizerUtil.levenshteinDistance(sourceWord, targetWord);

    assertEquals(expectedLevenshteinDistance, levenshteinDistance);
  }

  @Test
  void testLevenshteinDistance_whenSourceWordIsEmpty() {
    final String sourceWord = "";
    final String targetWord = "software engineer";
    final Integer expectedLevenshteinDistance = 17;

    Integer levenshteinDistance = NormalizerUtil.levenshteinDistance(sourceWord, targetWord);

    assertEquals(expectedLevenshteinDistance, levenshteinDistance);
  }

  @Test
  void testLevenshteinDistance_whenTargetWordIsEmpty() {
    final String sourceWord = "software engineer";
    final String targetWord = "";
    final Integer expectedLevenshteinDistance = 17;

    Integer levenshteinDistance = NormalizerUtil.levenshteinDistance(sourceWord, targetWord);

    assertEquals(expectedLevenshteinDistance, levenshteinDistance);
  }
}
