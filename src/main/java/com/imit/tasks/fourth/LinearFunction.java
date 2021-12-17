package com.imit.tasks.fourth;

public class LinearFunction implements IOneRealArgumentFunction {
    double A, B, x;
    double right, left;

    public LinearFunction(double a, double b, double right, double left) {
        A = a;
        B = b;
        this.right = right;
        this.left = left;
    }

    @Override
    public double getValue(double x) {
        return A * x + B;
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
