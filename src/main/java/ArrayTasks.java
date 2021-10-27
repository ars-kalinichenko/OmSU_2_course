import java.util.Arrays;
import java.util.Scanner;

// TODO: add package
public class ArrayTasks {
    private static final Scanner sc = new Scanner(System.in);

    public static void printArray(int[] array) {
        for (int element : array) {
            System.out.println(element);
        }
    }

    public static int[] inputArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }
        return array;
    }

    public static int sumElements(int[] array) {
        return Arrays.stream(array).sum();
    }

    public static long getCountOfEven(int[] array) {
        return Arrays.stream(array).filter(x -> x % 2 == 0).count();
    }

    public static long getCountOfRanged(int l, int r, int[] array) {
        return Arrays.stream(array).filter(x -> x <= r && x >= l).count();
    }

    public static boolean isPositiveArray(int[] array) {
        return Arrays.stream(array).allMatch(x -> x > 0);
    }

    public static void reverseArray(int[] array) {
        int temp;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5};
        reverseArray(array);
        System.out.println(Arrays.toString(array));
    }
}
