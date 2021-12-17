package com.imit.tasks.fourth;

public class RationalFunction implements IOneRealArgumentFunction {
    double A, B, D, C;
    double right, left;

    public RationalFunction(double a, double b, double c, double d, double left, double right) {
        A = a;
        B = b;
        D = d;
        C = c;
        this.left = left;
        this.right = right;
    }

    @Override
    public double getValue(double x) throws IllegalArgumentException {
        if (x > right || x < left) throw new IllegalArgumentException();
        return (A * x + B) / (C * x + D);
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
