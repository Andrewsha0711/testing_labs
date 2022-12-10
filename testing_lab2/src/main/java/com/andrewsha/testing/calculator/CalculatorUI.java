package com.andrewsha.testing.calculator;

import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 * CalculatorUI
 */
public class CalculatorUI extends Stage implements CalculatorPresenter {
	private static Calculator calculator = new CalculatorImpl();
	private static CalculatorView calculatorView = new CalculatorViewImpl();
	private static CalculatorPresenter calculatorPresenter = new CalculatorPresenterImpl();

	private List<Button> digitButtons = new ArrayList<>();

	private final Button sumButton = new Button("+");
	private final Button subtractButton = new Button("-");
	private final Button multiplyButton = new Button("*");
	private final Button divideButton = new Button("/");
	private final Button calculateButton = new Button("=");
	// create a stack pane
	private final TilePane r = new TilePane();
	// create a label
	Label l = new Label("");

	public CalculatorUI() {
		this.setTitle("calculator");
		this.digitButtons.add((new Button("0")));
		this.digitButtons.add((new Button("1")));
		this.digitButtons.add((new Button("2")));
		this.digitButtons.add((new Button("3")));
		this.digitButtons.add((new Button("4")));
		this.digitButtons.add((new Button("5")));
		this.digitButtons.add((new Button("6")));
		this.digitButtons.add((new Button("7")));
		this.digitButtons.add((new Button("8")));
		this.digitButtons.add((new Button("9")));

		((CalculatorPresenterImpl) calculatorPresenter).setLabel(l);
		((CalculatorViewImpl) calculatorView).setLabel(l);

		EventHandler<ActionEvent> clickOnDigitEvent = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				onDigitClicked(((Button) e.getSource()).getText());
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
				onCalculateClicked();
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
		this.setScene(sc);
	}

	@Override
	public void onPlusClicked() {
		calculatorPresenter.onPlusClicked();
	}

	@Override
	public void onMinusClicked() {
		calculatorPresenter.onMinusClicked();
	}

	@Override
	public void onDivideClicked() {
		calculatorPresenter.onDivideClicked();
	}

	@Override
	public void onMultiplyClicked() {
		calculatorPresenter.onMultiplyClicked();
	}

	public void onDigitClicked(String d) {
		if (((CalculatorViewImpl) calculatorView).isCleanLabelFlag()) {
			((CalculatorViewImpl) calculatorView).cleanLabel();
		}
		l.setText(l.getText().concat(d));
	}

	public String onCalculateClicked() {
		String a = calculatorView.getFirstArgumentAsString();
		String b = calculatorView.getSecondArgumentAsString();
		String operation = ((CalculatorPresenterImpl) calculatorPresenter).getCurrentOperation();
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
			return String.valueOf(res);
		} else {
			calculatorView.displayError("Cannot resolve");
			return null;
		}
	}
}
