package third;

import com.imit.tasks.third.PackagedWeightProduct;
import com.imit.tasks.third.ProductBatch;
import com.imit.tasks.third.ProductPackaging;
import com.imit.tasks.third.WeightProduct;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ProductBatchTest {
    ProductPackaging productPackaging = new ProductPackaging("Box", 10.0);
    PackagedWeightProduct[] weightProducts = {new PackagedWeightProduct(productPackaging, 11.0, new WeightProduct("1", "2"))};

    ProductBatch productBatch = new ProductBatch("xxx", weightProducts);

    @Test
    public void testGetDescription() {
        assertEquals(productBatch.getDescription(), "xxx");
    }

    @Test
    public void testGetProducts() {
        assertEquals(productBatch.getProducts(), weightProducts);
    }

    @Test
    public void testGetWeight() {
        assertEquals(productBatch.getWeight(), 21.0);
    }
}