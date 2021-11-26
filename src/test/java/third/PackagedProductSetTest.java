package third;

import com.imit.tasks.third.PackagedPieceProduct;
import com.imit.tasks.third.PackagedProductSet;
import com.imit.tasks.third.PieceProduct;
import com.imit.tasks.third.ProductPackaging;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class PackagedProductSetTest {
    ProductPackaging productPackaging = new ProductPackaging("коробка", 10.0);
    PieceProduct apple = new PieceProduct("яблоки", "зеленые", 100.0);
    PackagedPieceProduct appleBox = new PackagedPieceProduct(productPackaging, 10, apple);
    PackagedPieceProduct[] products = {appleBox, appleBox};
    PackagedProductSet set = new PackagedProductSet("фрукты", "разные фрукты", productPackaging, products);

    @Test
    public void testGetProducts() {
        assertEquals(set.getProducts(), products);
    }

    @Test
    public void testGetNetWeight() {
        assertEquals(set.getNetWeight(), 2020.0);
    }

    @Test
    public void testGetGrossWeight() {
        assertEquals(set.getGrossWeight(), 2030.0);
    }
}