package com.normalizer.job_normalizer.controllers;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class IntegrationTestConfig {

  @LocalServerPort
  private int port;

  @Bean
  public TestRestTemplate testRestTemplate() {
    return new TestRestTemplate();
  }
}
