package com.andrewsha.testing.calculator;

import javafx.scene.control.Label;

public class CalculatorViewImpl implements CalculatorView {
    private Label label;
    private boolean cleanLabelFlag = false;

    @Override
    public void printResult(double result) {
        if (this.label != null) {
            this.label.setText(String.valueOf(result));
        }
        this.cleanLabelFlag = true;
    }

    @Override
    public void displayError(String message) {
        if (this.label != null) {
            this.label.setText(message);
        }
    }

    @Override
    public String getFirstArgumentAsString() {
        if (this.label != null) {
            return this.label.getText().split(" ")[0];
        }
        return null;
    }

    @Override
    public String getSecondArgumentAsString() {
        if (this.label != null) {
            return this.label.getText().split(" ")[2];
        }
        return null;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Label getLabel() {
        return label;
    }

    public boolean isCleanLabelFlag() {
        return cleanLabelFlag;
    }

    public void setCleanLabelFlag(boolean cleanLabelFlag) {
        this.cleanLabelFlag = cleanLabelFlag;
    }

    public void cleanLabel() {
        this.label.setText("");
        this.cleanLabelFlag = false;
    }
}
