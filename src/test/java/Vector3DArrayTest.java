import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class Vector3DArrayTest {

    private final Vector3DArray varray = new Vector3DArray(5);


    @Test
    public void testGetMaxLength() {
        double len = new Vector3D(3, 2, 2).getLength();
        assertEquals(varray.maxVectorLength(), len);
    }

    @BeforeMethod
    public void setUp() {
        Vector3D vector3D = new Vector3D(1, 2, 3);
        varray.set(vector3D, 0);
        Vector3D v = new Vector3D(2, 3, 2);
        varray.set(v, 3);
    }

    @Test
    public void testGetLinearCombinationWell() {
        double[] koef = {1, 2, 0, 0, 1};
        assertEquals(varray.lineCombination(koef), new Vector3D(1, 2, 3));
    }

    @Test
    public void testLength() {
        assertEquals(varray.length(), 5);
    }

    @Test
    public void testGetElement() {
        assertEquals(varray.getElement(0), new Vector3D(1, 2, 3));
    }

    @Test
    public void testChangeElement() {
        Vector3D vector3D = new Vector3D(1, 2, 3);
        varray.set(vector3D, 1);
        assertEquals(varray.getElement(1), vector3D);
        vector3D.setX(10);
        assertNotEquals(varray.getElement(1), vector3D);
    }


    @Test(dependsOnMethods = {"testGetMaxLength"})
    public void testFindIndex() {
        Vector3D v = new Vector3D(2, 3, 2);
        assertEquals(varray.contains(v), 3);
    }

    @Test
    public void testFindIndexZ() {
        Vector3D v = new Vector3D(2, 3, 100);
        assertEquals(varray.contains(v), -1);
    }

    @Test
    public void testGetSumOfVectors() {
        Vector3D sum = new Vector3D(3, 5, 5);
        assertEquals(varray.sumAllVectors(), sum);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void testGetLinearCombination() {
        double[] coef = {1, 2, 0, 1};
        Vector3D actual = varray.lineCombination(coef);
    }


    @Test
    public void testGetPointShiftArray() {
        Point3D point = new Point3D(1, 1, 1);
        Point3D[] expected = new Point3D[5];
        for (int i = 0; i < 5; i++) {
            expected[i] = new Point3D(1, 1, 1);
        }
        expected[0] = new Point3D(2, 3, 4);
        expected[3] = new Point3D(3, 4, 3);

        assertEquals(varray.pointSwap(point), expected);
    }
}