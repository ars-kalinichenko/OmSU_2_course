package third;

import com.imit.tasks.third.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ProductServiceTest {

    private ProductBatch batch;
    private ProductBatch weightBatch;

    @BeforeMethod
    public void setUp() {
        ProductPackaging productPackaging = new ProductPackaging("коробка", 10.0);
        PieceProduct apple = new PieceProduct("яблоки", "зеленые", 100.0);
        PackagedPieceProduct appleBox = new PackagedPieceProduct(productPackaging, 10, apple);
        PackagedProductSet set = new PackagedProductSet("фрукты", "разные фрукты", productPackaging, appleBox, appleBox);
        batch = new ProductBatch("Партия товаров", appleBox,
                set, new PackagedProductSet("овощи", "разные фрукты", productPackaging, appleBox, set));
        WeightProduct weightProduct = new WeightProduct("мармеладки", "вкусные");
        PackagedWeightProduct marshmallowBox = new PackagedWeightProduct(productPackaging, 100.0, weightProduct);
        weightBatch = new ProductBatch("Партия мармеладок", marshmallowBox);
    }


    @Test
    public void testCounter() {
        assertEquals(ProductService.countByFilter(batch, new BeginStringFilter("яблоки")), 1);
        assertEquals(ProductService.countByFilter(batch, new ContainsStringFilter("зеленые")), 0);
        assertEquals(ProductService.countByFilter(batch, new BeginStringFilter("фрукты")), 1);
    }

    @Test
    public void testCheckAllWeighted() {
        assertFalse(ProductService.checkAllWeighted(batch));
        assertTrue(ProductService.checkAllWeighted(weightBatch));
    }

    @Test
    public void testDeepCounter() {
        assertEquals(ProductService.countByFilterDeep(batch, new BeginStringFilter("яблоки")), 3);
        assertEquals(ProductService.countByFilterDeep(weightBatch, new EndStringFilter("мармеладки")), 1);
    }
}