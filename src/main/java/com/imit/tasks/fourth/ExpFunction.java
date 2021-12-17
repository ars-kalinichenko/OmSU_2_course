package com.imit.tasks.fourth;

public class ExpFunction implements IOneRealArgumentFunction {
    double A, B;
    double right, left;

    public ExpFunction(double right, double left, double a, double b) {
        this.right = right;
        this.left = left;
        this.A = a;
        this.B = b;
    }

    @Override
    public double getValue(double x) {
        return A * Math.exp(x) + B;
    }

    @Override
    public double getRight() {
        return right;
    }

    @Override
    public double getLeft() {
        return left;
    }
}
