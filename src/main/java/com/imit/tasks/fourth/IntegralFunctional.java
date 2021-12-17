package com.imit.tasks.fourth;

public class IntegralFunctional<T extends IOneRealArgumentFunction> implements IFunctional<T> {
    private final double right, left;

    public IntegralFunctional(double right, double left) {
        this.right = right;
        this.left = left;
    }

    @Override
    public double calculate(T func) throws IllegalArgumentException {
        if (left < func.getLeft() || right > func.getRight()) throw new IllegalArgumentException();
        int n = 100;
        double result = 0.0;

        double d = Math.abs(right - left) / n;
        for (int i = 0; i < n; i++) {
            result += func.getValue(right + i * d + d / 2) * d;
        }
        return result;
    }
}
