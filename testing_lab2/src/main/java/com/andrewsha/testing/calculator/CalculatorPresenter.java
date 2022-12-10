package com.andrewsha.testing.calculator;

public interface CalculatorPresenter {
    /**
     * Вызывается формой в тот момент, когда пользователь нажал на кнопку '+'
     */
    public void onPlusClicked();

    /**
     * Вызывается формой в тот момент, когда пользователь нажал на кнопку '-'
     */
    public void onMinusClicked();

    /**
     * Вызывается формой в тот момент, когда пользователь нажал на кнопку '/'
     */
    public void onDivideClicked();

    /**
     * Вызывается формой в тот момент, когда пользователь нажал на кнопку '*'
     */
    public void onMultiplyClicked();
}
