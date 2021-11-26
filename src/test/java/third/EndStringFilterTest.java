package third;

import com.imit.tasks.third.EndStringFilter;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EndStringFilterTest {
    EndStringFilter filter = new EndStringFilter("раму");

    @Test
    public void testGetPattern() {
        assertEquals(filter.getPattern(), "раму");
    }

    @Test
    public void testApplyOK() {
        assertTrue(filter.apply("мама мыла раму"));
    }

    @Test
    public void testApplyFalse() {
        assertFalse(filter.apply("мама Мыла рамку"));
        assertFalse(filter.apply("папа мыл что-то"));
    }
}