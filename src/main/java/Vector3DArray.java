public class Vector3DArray {
    private final Vector3D[] arr;
    private final int size;

    Vector3DArray(int n) {
        if (n <= 0) throw new ArithmeticException("Size error");
        this.size = n;
        this.arr = new Vector3D[this.size];
        for (int i = 0; i < n; i++) {
            arr[i] = new Vector3D();
        }
    }

    public void set(Vector3D v, int ind) {
        if (ind < 0 || ind >= this.size) throw new ArithmeticException("Index error");
        if (v == null) throw new NullPointerException("Method set isn't get null");
        arr[ind] = v;
    }

    public double maxVectorLength() {
        double res = -1;
        double temp;

        for (int i = 0; i < size; i++) {
            temp = arr[i].length();
            if (temp > res) res = temp;
        }

        return res;
    }

    public int contains(Vector3D v) {
        if (v == null) throw new NullPointerException("Method contains isn't get null");
        for (int i = 0; i < this.size; i++) {
            if (arr[i].equals(v)) return i;
        }
        return -1;
    }

    public int length() {
        return this.size;
    }

    public Point3D[] pointSwap(Point3D point) {
        if (point == null) throw new NullPointerException("Method pointSwap isn't get null");
        Point3D[] data = new Point3D[this.size];
        for (int i = 0; i < this.size; i++) {
            data[i] = new Point3D(
                    point.getX() + (arr[i].getEnd().getX() - arr[i].getStart().getX()),
                    point.getY() + (arr[i].getEnd().getY() - arr[i].getStart().getY()),
                    point.getZ() + (arr[i].getEnd().getZ() - arr[i].getStart().getZ())
            );
        }
        return data;
    }

    public Vector3D sumAllVectors() {
        Vector3D res = arr[0];
        for (int i = 1; i < this.size; i++) {
            res = Vector3DProcessor.sum(res, arr[i]);
        }
        return res;
    }

    public Vector3D getElement(int index) {
        return this.arr[index];
    }

    public static void main(String[] args) {

    }
}