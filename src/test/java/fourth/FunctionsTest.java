package fourth;

import com.imit.tasks.fourth.ExpFunction;
import com.imit.tasks.fourth.LinearFunction;
import com.imit.tasks.fourth.RationalFunction;
import com.imit.tasks.fourth.SinFunction;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FunctionsTest {

    @Test
    public void testLinearFunction() {
        LinearFunction linearFunction = new LinearFunction(1, 2, 1, 10);
        assertEquals(linearFunction.getValue(2), 4);
    }

    @Test
    public void testExpFunction() {
        ExpFunction expFunction = new ExpFunction(1, 2, 1, 0);
        assertTrue(expFunction.getValue(2) - 7.38 < 0.1);
    }

    @Test
    public void testSinFunction() {
        SinFunction sinFunction = new SinFunction(0, 1, 1, 1);
        assertTrue(sinFunction.getValue(0.1) - 0.099 < 0.1);
    }

    @Test
    public void testRationalFunction() {
        RationalFunction rationalFunction = new RationalFunction(10, 2, 1,1, 0, 10);
        assertTrue(rationalFunction.getValue(2) - 7.333 < 0.1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testError() {
        ExpFunction expFunction = new ExpFunction(1, 2, 1, 0);
        expFunction.getValue(100);
    }
}