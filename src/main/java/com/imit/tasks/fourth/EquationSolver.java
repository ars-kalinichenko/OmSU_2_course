/*
mvn install:install-file -Dfile=OmSU_2_course/src/lib/ars_plugin-1.0-SNAPSHOT.jar
 -DgroupId=com.example -DartifactId=ars_plugin -Dversion=1.0 -Dpackaging=jar -DgeneratePom=true

<update local mvn repo>
 */

package com.imit.tasks.fourth;


import com.example.SquareTrinomialTest;

import java.util.Arrays;
import java.util.Objects;

public class EquationSolver {
    SquareTrinomialTest equation;

    public EquationSolver(SquareTrinomialTest equation) {
        this.equation = equation;
    }

    public SquareTrinomialTest getEquation() {
        return equation;
    }

    public void setEquation(SquareTrinomialTest equation) {
        this.equation = equation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EquationSolver)) return false;
        EquationSolver that = (EquationSolver) o;
        return getEquation().equals(that.getEquation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEquation());
    }

    @Override
    public String toString() {
        return String.format("Equation: %fa + %fb + %f = 0", equation.getA(), equation.getB(), equation.getC());
    }

    public double getMaxAnswer() throws IllegalArgumentException {
        return Arrays.stream(equation.getAnswer()).max().orElseThrow(IllegalArgumentException::new);
    }

}
