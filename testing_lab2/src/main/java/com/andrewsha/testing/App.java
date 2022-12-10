package com.andrewsha.testing;

import com.andrewsha.testing.calculator.CalculatorUI;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application {


	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// set title for the stage
		stage = new CalculatorUI();
		stage.show();
	}
}
