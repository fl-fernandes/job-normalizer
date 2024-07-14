package com.normalizer.job_normalizer.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.normalizer.job_normalizer.utils.NormalizerUtil;

@Service
public class DefaultNormalizationService implements NormalizationService {
  private static List<String> SUPPORTED_NORMALIZED_JOB_NAMES = List.of(
    "Software engineer",
    "Accountant",
    "Architect",
    "Quantity surveyor"
  );
  
  public String normalize(final String jobName) {
    String normalizedName = findBestMatch(jobName);
    return normalizedName;
  }

  private String findBestMatch(String jobName) {
    Integer bestMatchDistance = null;
    String bestMatch = null;
    jobName = jobName.toLowerCase();

    for (String normalizedJobName : SUPPORTED_NORMALIZED_JOB_NAMES) {
      String lowercaseNormalizedJobName = normalizedJobName.toLowerCase();
      Integer distance = NormalizerUtil.levenshteinDistance(
          jobName, lowercaseNormalizedJobName);

      if (bestMatchDistance == null || distance < bestMatchDistance) {
        bestMatchDistance = distance;
        bestMatch = normalizedJobName;
      }
    }

    return bestMatch;
  }
}
