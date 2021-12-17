package fourth;

import com.imit.tasks.fourth.ComparatorDemo;
import com.imit.tasks.third.Product;
import com.imit.tasks.third.WeightProduct;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class ComparatorDemoTest {

    @Test
    public void testSortProducts() {
        Product[] products = {
                new WeightProduct("yyy", "red"),
                new WeightProduct("apple", "z"),
                new WeightProduct("Apple", "a")};
        Product[] sorted = {
                new WeightProduct("Apple", "a"),
                new WeightProduct("apple", "z"),
                new WeightProduct("yyy", "red")};

        ComparatorDemo.sortProducts(products);
        assertArrayEquals(products, sorted);
    }
}