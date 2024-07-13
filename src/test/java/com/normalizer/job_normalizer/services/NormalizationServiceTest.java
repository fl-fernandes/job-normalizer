package com.normalizer.job_normalizer.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NormalizationServiceTest {
  @Autowired
  private NormalizationService normalizationService;

  @Test
  void testNormalization_whenSoftwareEngineerIsTheBestMatch() {
    final String jobName = "java engineer";
    final String expectedNormalizedJobName = "Software engineer";

    final String normalizedJobName = normalizationService.normalize(jobName);
    
    assertEquals(expectedNormalizedJobName, normalizedJobName);
  }

  @Test
  void testNormalization_whenAccountantIsTheBestMatch() {
    final String jobName = "chief accountant";
    final String expectedNormalizedJobName = "Accountant";

    final String normalizedJobName = normalizationService.normalize(jobName);
    
    assertEquals(expectedNormalizedJobName, normalizedJobName);
  }

  @Test
  void testNormalization_whenInputIsNotLowerCase() {
    final String jobName = "chief ACCOUNTANT";
    final String expectedNormalizedJobName = "Accountant";

    final String normalizedJobName = normalizationService.normalize(jobName);
    
    assertEquals(expectedNormalizedJobName, normalizedJobName);
  }
}
