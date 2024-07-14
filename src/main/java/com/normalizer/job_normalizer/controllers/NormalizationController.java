package com.normalizer.job_normalizer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.normalizer.job_normalizer.models.JobNormalizationRequest;
import com.normalizer.job_normalizer.models.JobNormalizationResponse;
import com.normalizer.job_normalizer.services.NormalizationService;

@RestController
@RequestMapping("/normalize")
public class NormalizationController {
  @Autowired
  private NormalizationService normalizationService;

  @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public JobNormalizationResponse normalize(@RequestBody final JobNormalizationRequest request) {
    final String normalizedJobName = normalizationService.normalize(request.jobName());
    return new JobNormalizationResponse(normalizedJobName);
  }
}
