package third;

import com.imit.tasks.third.*;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ProductServiceTest {
    //    todo: to data provider
    ProductPackaging productPackaging = new ProductPackaging("коробка", 10.0);
    PieceProduct apple = new PieceProduct("яблоки", "зеленые", 100.0);
    PackagedPieceProduct appleBox = new PackagedPieceProduct(productPackaging, 10, apple);
    ProductBatch batch = new ProductBatch("Партия товаров", appleBox,
            new PackagedPieceProductSet("фрукты", "разные фрукты", productPackaging, appleBox, appleBox));

    @Test
    public void testCounter() {
        assertEquals(ProductService.countByFilter(batch, new BeginStringFilter("яблоки")), 1);
        assertEquals(ProductService.countByFilter(batch, new ContainsStringFilter("зеленые")), 0);
        assertEquals(ProductService.countByFilter(batch, new BeginStringFilter("фрукты")), 1);

    }
}