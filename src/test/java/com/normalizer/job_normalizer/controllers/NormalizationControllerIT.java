package com.normalizer.job_normalizer.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.normalizer.job_normalizer.models.JobNormalizationRequest;
import com.normalizer.job_normalizer.models.JobNormalizationResponse;
import com.normalizer.job_normalizer.services.NormalizationService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class NormalizationControllerIT {
  private static String NORMALIZE_ENDPOINT_URL = "/normalize";

  @Autowired
  private TestRestTemplate restTemplate;

  @MockBean
  private NormalizationService normalizationService;

  @Test
  void testPostNormalize() {
    final String sourceJobName = "java engineer";
    final String expectedNormalizedJobName = "Software engineer";
    final JobNormalizationRequest request = new JobNormalizationRequest(sourceJobName);

    when(normalizationService.normalize(sourceJobName))
      .thenReturn(expectedNormalizedJobName);

    final JobNormalizationResponse response = restTemplate.postForObject(
          NORMALIZE_ENDPOINT_URL, request, JobNormalizationResponse.class);

    verify(normalizationService, times(1)).normalize(sourceJobName);
    assertEquals(expectedNormalizedJobName, response.normalizedJobName());
  }
}
