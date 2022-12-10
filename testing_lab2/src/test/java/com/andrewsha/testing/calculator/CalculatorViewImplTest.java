package com.andrewsha.testing.calculator;

import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

@ExtendWith(ApplicationExtension.class)
public class CalculatorViewImplTest {
	
	private static Calculator calculator = new CalculatorImpl();
	private static CalculatorView calculatorView = new CalculatorViewImpl();
	private static CalculatorPresenter calculatorPresenter = new CalculatorPresenterImpl();

	Button sumButton;
	Label l;
	List<Button> digitButtons;
	Button calculateButton;

	@Start
	public void start(Stage stage) {
		stage.setTitle("calculator");
		// create a buttons
		digitButtons = List.of(new Button("0"), new Button("1"), new Button("2"), new Button("3"),
				new Button("4"), new Button("5"), new Button("6"), new Button("7"), new Button("8"),
				new Button("9"));

		sumButton = new Button("+");
		Button subtractButton = new Button("-");
		Button multiplyButton = new Button("*");
		Button divideButton = new Button("/");

		calculateButton = new Button("=");
		// create a stack pane
		TilePane r = new TilePane();
		// create a label
		l = new Label("");
		((CalculatorPresenterImpl) calculatorPresenter).setLabel(l);
		((CalculatorViewImpl) calculatorView).setLabel(l);

		EventHandler<ActionEvent> clickOnDigitEvent = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String digit = ((Button) e.getSource()).getText();
				if (((CalculatorViewImpl) calculatorView).isCleanLabelFlag()) {
					((CalculatorViewImpl) calculatorView).cleanLabel();
				}
				l.setText(l.getText().concat(digit));
			}
		};
		EventHandler<ActionEvent> clickOnPlus = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				calculatorPresenter.onPlusClicked();
			}
		};
		EventHandler<ActionEvent> clickOnMinus = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				calculatorPresenter.onMinusClicked();
			}
		};
		EventHandler<ActionEvent> clickOnMultiply = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				calculatorPresenter.onMultiplyClicked();
			}
		};
		EventHandler<ActionEvent> clickOnDivide = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				calculatorPresenter.onDivideClicked();
			}
		};
		EventHandler<ActionEvent> clickOnCalculateEvent = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String a = calculatorView.getFirstArgumentAsString();
				String b = calculatorView.getSecondArgumentAsString();
				String operation =
						((CalculatorPresenterImpl) calculatorPresenter).getCurrentOperation();
				Double res = null;
				if (operation.equals("+")) {
					res = calculator.sum(Double.parseDouble(a), Double.parseDouble(b));
				}
				if (operation.equals("-")) {
					res = calculator.subtract(Double.parseDouble(a), Double.parseDouble(b));
				}
				if (operation.equals("*")) {
					res = calculator.multiply(Double.parseDouble(a), Double.parseDouble(b));
				}
				if (operation.equals("/")) {
					res = calculator.divide(Double.parseDouble(a), Double.parseDouble(b));
				}
				if (res != null) {
					calculatorView.printResult(res);
				} else {
					calculatorView.displayError("Cannot resolve");
				}
			}
		};
		for (Button button : digitButtons) {
			button.setOnAction(clickOnDigitEvent);
			r.getChildren().add(button);
		}

		sumButton.setOnAction(clickOnPlus);
		subtractButton.setOnAction(clickOnMinus);
		multiplyButton.setOnAction(clickOnMultiply);
		divideButton.setOnAction(clickOnDivide);

		calculateButton.setOnAction(clickOnCalculateEvent);

		r.getChildren().add(sumButton);
		r.getChildren().add(subtractButton);
		r.getChildren().add(multiplyButton);
		r.getChildren().add(divideButton);
		r.getChildren().add(calculateButton);
		r.getChildren().add(l);
		// create a scene
		Scene sc = new Scene(r, 200, 200);
		// set the scene
		stage.setScene(sc);
		stage.show();
	}

//	@Test
//	public void testPrintOperandsAndOperations(FxRobot robot) {
//		// given:
//		robot.clickOn(this.digitButtons.get(1));
//		robot.clickOn(sumButton);
//		robot.clickOn(this.digitButtons.get(2));
//		// when:
//		// then:
//		Assertions.assertThat(l).hasText("1 + 2");
//	}
//
//
//	@Test
//	public void testPrintResult(FxRobot robot) {
//		// given:
//		robot.clickOn(this.digitButtons.get(1));
//		robot.clickOn(sumButton);
//		robot.clickOn(this.digitButtons.get(2));
//		robot.clickOn(this.calculateButton);
//		// then:
//		Assertions.assertThat(l).hasText("3.0");
//	}
//
//
}
