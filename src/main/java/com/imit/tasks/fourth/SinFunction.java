package com.imit.tasks.fourth;

public class SinFunction implements IOneRealArgumentFunction {
    double A, B;
    double right, left;

    public SinFunction(double right, double left, double a, double b) {
        this.right = right;
        this.left = left;
        A = a;
        B = b;
    }

    @Override
    public double getValue(double x) {
        return A * Math.sin(B * x);
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
