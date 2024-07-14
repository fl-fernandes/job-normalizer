package com.normalizer.job_normalizer.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record JobNormalizationResponse(
    @JsonProperty("normalizedJobName") String normalizedJobName) {}
