package com.normalizer.job_normalizer.utils;

import java.util.Arrays;

/**
 * Utility class for String normalization. All its methods are static.
 */
final public class NormalizerUtil {
  private NormalizerUtil() {}

  /**
   * Calculate the Levenshtein distance of two given words.
   * [This function is case-sensitive*]
   * 
   * The Levenshtein distance is the minimun number of single-character edits
   * Required to change one word into the other.
   * 
   * This implementation was based on
   * https://en.wikipedia.org/wiki/Levenshtein_distance
   * 
   * @param sourceWord - The source word to be transformed
   * @param targetWord - The targed word to turn the first into
   * @return Integer - The Levenshtein distance
   */
  public static Integer levenshteinDistance(
      final String sourceWord, final String targetWord) {
    int[][] distances = new int[sourceWord.length() + 1][targetWord.length() + 1];
    int substitutionCost;

    for (int i = 0; i <= sourceWord.length(); i++) {
      for (int j = 0; j <= targetWord.length(); j++) {
        if (i == 0) {
          distances[i][j] = j;
        }
        else if (j == 0) {
          distances[i][j] = i;
        }
        else {
          substitutionCost = 0;
          if (sourceWord.charAt(i - 1) != targetWord.charAt(j - 1)) {
            substitutionCost = 1;
          }
          distances[i][j] = minimum(
            distances[i][j-1] + 1, // insertion
            distances[i-1][j] + 1, // deletion
            distances[i-1][j-1] + substitutionCost // substitution
          );
        }
      }
    }

    return distances[sourceWord.length()][targetWord.length()];
  }

  private static int minimum(int... operationCosts) {
    return Arrays.stream(operationCosts).min().orElse(Integer.MAX_VALUE);
  }
}
