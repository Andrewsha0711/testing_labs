package com.andrewsha.testing.cucumber;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * RunCucumber
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com/andrewsha/testing",
        tags = "@calculator"
)
public class RunCucumber {
	
}
