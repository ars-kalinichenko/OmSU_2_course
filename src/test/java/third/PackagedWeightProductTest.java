package third;

import com.imit.tasks.third.PackagedWeightProduct;
import com.imit.tasks.third.ProductPackaging;
import com.imit.tasks.third.WeightProduct;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PackagedWeightProductTest {
    PackagedWeightProduct product = new PackagedWeightProduct(new ProductPackaging("Пакет", 90.0),
            9000.99, new WeightProduct("Угли", "Древесные угли"));

    @Test
    public void testGetNetWeight() {
        assertEquals(product.getNetWeight(), 9000.99);
    }

    @Test
    public void testGetGrossWeight() {
        assertEquals(product.getGrossWeight(), 9090.99);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public static void testConstructorNegativeWeight() {
        PackagedWeightProduct product = new PackagedWeightProduct(new ProductPackaging("Пакет", 90.0),
                -9000.99, new WeightProduct("Угли", "Древесные угли"));
    }
}