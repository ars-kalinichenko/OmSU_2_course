package fourth;

import com.example.SquareTrinomialTest;
import com.imit.tasks.fourth.EquationSolver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EquationSolverTest {

    @Test
    public void testGetMaxAnswer() {
        SquareTrinomialTest equation = new SquareTrinomialTest(3, -14, -5);
        EquationSolver solver = new EquationSolver(equation);
        assertEquals(solver.getMaxAnswer(), 5.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGetException() {
        SquareTrinomialTest equation = new SquareTrinomialTest(1, 6, 14);
        EquationSolver solver = new EquationSolver(equation);
        solver.getMaxAnswer();
    }
}