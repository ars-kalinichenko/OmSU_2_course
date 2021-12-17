package com.imit.tasks.fourth;

public class SumFunctional<T extends IOneRealArgumentFunction> implements IFunctional<T> {
    @Override
    public double calculate(T func) {
        return func.getValue(func.getRight()) +
                func.getValue(func.getLeft()) +
                func.getValue((func.getRight() + func.getRight()) / 2);
    }
}
