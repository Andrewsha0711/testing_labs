package com.andrewsha.testing.calculator;

import javafx.scene.control.Label;

public class CalculatorPresenterImpl implements CalculatorPresenter {

    private String currentOperation;
    private Label label;

    @Override
    public void onPlusClicked() {
        this.currentOperation = "+";
        this.label.setText(this.label.getText().concat(" + "));
    }

    @Override
    public void onMinusClicked() {
        this.currentOperation = "-";
        this.label.setText(this.label.getText().concat(" - "));
    }

    @Override
    public void onDivideClicked() {
        this.currentOperation = "/";
        this.label.setText(this.label.getText().concat(" / "));
    }

    @Override
    public void onMultiplyClicked() {
        this.currentOperation = "*";
        this.label.setText(this.label.getText().concat(" * "));
    }

    public String getCurrentOperation() {
        return currentOperation;
    }

    public void setCurrentOperation(String currentOperation) {
        this.currentOperation = currentOperation;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

}
