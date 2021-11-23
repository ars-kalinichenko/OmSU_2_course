package first;

import com.imit.tasks.first.Point3D;
import com.imit.tasks.first.Vector3D;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class Vector3DTest {
    @Test
    public void testVector3D() {
        Vector3D vector1 = new Vector3D(1, 2, 3);
        Vector3D vector2 = new Vector3D(new Point3D(1, 2, 3), new Point3D(5, 6, 7));
        Vector3D vector3 = new Vector3D(new Point3D(1, 2, 3), new Point3D(5, 6, 7));

        assertNotEquals(vector1, vector2);
        assertEquals(vector3, vector2);

        System.out.println(vector1.getLength());

        System.out.println(vector3);
    }

}
