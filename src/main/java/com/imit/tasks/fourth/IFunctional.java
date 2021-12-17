package com.imit.tasks.fourth;

public interface IFunctional<T extends IOneRealArgumentFunction> {
    double calculate(T func);
}
