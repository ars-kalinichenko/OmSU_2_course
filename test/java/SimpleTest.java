import com.imit.SimpleTasks;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SimpleTest {
    @DataProvider
    public static Object[][] fourth() {
        return new Object[][]{
                {1, 4, 4, new double[]{-2.0}},
                {2, 8, 8, new double[]{-2.0}},
                {2, 10, 12, new double[]{-2.0, -3.0}}
        };
    }

    @DataProvider
    public static Object[][] fifth() {
        return new Object[][]{
                {0, 0, 0},
                {0, 0, -0.1},
                {0, 0, 0.1},
                {1, 0, 0},
                {1, 0, 0.1},
                {0, 1, 0},
                {0, 1, -0.1}
        };
    }

    @DataProvider
    public static Object[][] fourthEx() {
        return new Object[][]{
                {0, 0, 0},
                {0, 0, 1},
                {0, 1, 2}
        };
    }

    @DataProvider
    public static Object[][] seven() {
        return new Object[][]{
                {0.0, 1e-10, Math.exp(0.0)},
                {2.0, 1e-10, Math.exp(2.0)},
                {-2.0, 1e-10, Math.exp(-2.0)}
        };
    }

    @Test(dataProvider = "fourth")
    public void testFourthTask(double a, double b, double c, double[] expected) {
        double[] actual = SimpleTasks.fourthTask(a, b, c);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "fourthEx", expectedExceptions = {IllegalArgumentException.class})
    public void testFourthTask(double a, double b, double c) {
        SimpleTasks.fourthTask(a, b, c);
    }

    @Test(dataProvider = "fifth", expectedExceptions = {IllegalArgumentException.class})
    public void testFifth(double inf, double sup, double step) {
        SimpleTasks.fifthTask(inf, sup, step);
    }

    @Test
    public void testFifth() {
        SimpleTasks.fifthTask(0, 1, 0.1);
    }

    @Test
    public void testSixth() {
        SimpleTasks.sixthTask(0, 0, 0, 0, 0, 0);
        System.out.println();

        SimpleTasks.sixthTask(0, 0, 1, 0, 0, 0);
        SimpleTasks.sixthTask(0, 0, 0, 0, 0, 1);
        SimpleTasks.sixthTask(1, 2, 3, 0, 0, 1);
        SimpleTasks.sixthTask(1, 0, 3, 2, 0, 7);
        SimpleTasks.sixthTask(0, 2, 3, 0, 5, 7);
        SimpleTasks.sixthTask(1, 2, 3, 2, 4, 7);
        System.out.println();

        SimpleTasks.sixthTask(1, 2, 3, 0, 0, 0);
        SimpleTasks.sixthTask(1, 2, 3, 2, 4, 6);
        SimpleTasks.sixthTask(0, 2, 3, 0, 4, 6);
        SimpleTasks.sixthTask(1, 0, 3, 2, 0, 6);
        System.out.println();

        SimpleTasks.sixthTask(1, 2, 3, 4, 5, 6);
    }

    @Test(dataProvider = "seven")
    public void testSeven(double x, double eps, double expected) {
        double actual = SimpleTasks.seventhTask(x, eps);
        assertEquals(actual, expected, eps);
    }
}