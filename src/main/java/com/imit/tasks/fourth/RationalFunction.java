package com.imit.tasks.fourth;

public class RationalFunction implements IOneRealArgumentFunction {
    double A, B, D, C;
    double right, left;

    public RationalFunction(double a, double b, double d, double c, double right, double left) {
        A = a;
        B = b;
        D = d;
        C = c;
        this.right = right;
        this.left = left;
    }

    @Override
    public double getValue(double x) {
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
