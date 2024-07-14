package com.normalizer.job_normalizer;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.normalizer.job_normalizer.controllers.NormalizationController;

@SpringBootTest
class JobNormalizerApplicationTests {

	@Autowired
	NormalizationController normalizationController;

	@Test
	void contextLoads() {
		assertNotNull(normalizationController);
	}

}
