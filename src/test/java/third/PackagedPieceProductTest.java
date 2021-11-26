package third;

import com.imit.tasks.third.PackagedPieceProduct;
import com.imit.tasks.third.PieceProduct;
import com.imit.tasks.third.ProductPackaging;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PackagedPieceProductTest {
    PieceProduct product = new PieceProduct("apple", "green apple", 200.00);
    PackagedPieceProduct packagedProduct = new PackagedPieceProduct(new ProductPackaging("pack", 10.0),
            10, product);


    @Test
    public void testGetCount() {
        assertEquals(packagedProduct.getCount(), 10);
    }

    @Test
    public void testGetProduct() {
        assertEquals(packagedProduct.getProduct(), product);
    }

    @Test
    public void testGetNetWeight() {
        assertEquals(packagedProduct.getNetWeight(), 2000.0);
    }

    @Test
    public void testGetGrossWeight() {
        assertEquals(packagedProduct.getGrossWeight(), 2010.0);
    }
}