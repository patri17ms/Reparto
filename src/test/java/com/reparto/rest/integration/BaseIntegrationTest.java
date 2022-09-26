package com.reparto.rest.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

/**
 * Base Integration Test.
 * <p>
 * This class is used by every integration test. In order to run as much
 * contexts as test exists, it will be run once. This provides a better
 * performance regarding test execution, but beans are going to be shared across
 * Tests, so it is mandatory to not modify them. If it is required a bean
 * modification, do NOT extend this base.
 */
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class BaseIntegrationTest {
    
    @LocalServerPort
    protected int port;

    @Autowired
    protected TestRestTemplate restTemplate;
    
}