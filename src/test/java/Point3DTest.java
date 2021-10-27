import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Point3DTest {
    @Test
    public void testPoint3D() {
        Point3D p1 = new Point3D();
        Point3D p2 = new Point3D();
        assertEquals(p1, p2);
        assertEquals(p1, p1);
    }
}
