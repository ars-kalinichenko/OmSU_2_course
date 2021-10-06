import java.util.Objects;

public class Vector3D {
    protected Point3D p1, p2;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector3D)) return false;
        Vector3D vector3D = (Vector3D) o;
        return p1.equals(vector3D.p1) && p2.equals(vector3D.p2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p1, p2);
    }

    public Vector3D(Point3D x1, Point3D x2) {
        this.p1 = x1;
        this.p2 = x2;
    }

    public Vector3D(double x1, double y1, double z1, double x2, double y2, double z2) {
        p1 = new Point3D(x1, y1, z1);
        p2 = new Point3D(x2, y2, z2);
    }

    public Vector3D() {
        p1 = new Point3D();
        p2 = new Point3D();
    }

    public double getVectorSize() {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }
}
