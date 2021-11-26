package third;

import com.imit.tasks.third.ContainsStringFilter;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ContainsStringFilterTest {

    ContainsStringFilter filter = new ContainsStringFilter("мыла");

    @Test
    public void testGetPattern() {
        assertEquals(filter.getPattern(), "мыла");
    }

    @Test
    public void testApplyOK() {
        assertTrue(filter.apply("мама мыла раму"));
    }

    @Test
    public void testApplyFalse() {
        assertFalse(filter.apply("мама Мыла раму"));
        assertFalse(filter.apply("папа мыл раму"));
    }
}