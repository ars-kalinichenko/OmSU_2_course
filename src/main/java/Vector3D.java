import java.util.Objects;

import static java.lang.Math.sqrt;

public class Vector3D {
    private Point3D start;
    private Point3D end;

    public Vector3D() {
        start = new Point3D();
        end = new Point3D();
    }

    public Vector3D(double x, double y, double z) {
        start = new Point3D();
        end = new Point3D(x, y, z);
    }

    public Vector3D(Point3D a, Point3D b) {
        start = a;
        end = b;
    }

    public double length() {
        return sqrt((start.getX() - end.getX()) * (start.getX() - end.getX()) + (start.getY() - end.getY()) * (start.getY() - end.getY()) + (start.getZ() - end.getZ()) * (start.getZ() - end.getZ()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3D vector3D = (Vector3D) o;
        return Objects.equals(start, vector3D.start) && Objects.equals(end, vector3D.end);
    }

    public Point3D getStart() {
        return start;
    }

    public void setStart(Point3D start) {
        this.start = start;
    }

    public Point3D getEnd() {
        return end;
    }

    public void setEnd(Point3D end) {
        this.end = end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return "Vector3D{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public static void main(String[] args) {
        Vector3D vector1 = new Vector3D(1, 2, 3);
        Vector3D vector2 = new Vector3D(new Point3D(1, 2, 3), new Point3D(5, 6, 7));
        Vector3D vector3 = new Vector3D(new Point3D(1, 2, 3), new Point3D(5, 6, 7));

        System.out.println(vector1.equals(vector2));
        System.out.println(vector3.equals(vector2));

        System.out.println(vector1.length());

        System.out.println(vector3);
    }
}