package com.andrewsha.testing.cucumber;

import com.andrewsha.testing.calculator.CalculatorUI;
import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Steps
 */
public class Steps {
	CalculatorUI calculator = new CalculatorUI();

	@Given("I have entered first number {double} into the calculator")
	public void iHaveEnteredFirstNumberIntoTheCalculator(double arg1) {
		calculator = new CalculatorUI();
	}
	
	@And("I press divide")
	public void iPressDivide() {}

	@When("I have entered second number {double} into the calculator")
	public void iHaveEnteredSecondNumberIntoTheCalculator(double arg2) {}

	@Then("the result should be {double} on the screen")
	public void theResultShouldBeOnTheScreen(double arg) {
		Assert.assertEquals(String.valueOf(arg), calculator.onCalculateClicked());
	}
}
