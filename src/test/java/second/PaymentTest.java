package second;

import com.imit.tasks.second.Payment;
import org.testng.annotations.Test;

import java.util.GregorianCalendar;

public class PaymentTest {
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSumInvalid() {
        Payment payment = new Payment("name", -42.0, new GregorianCalendar());
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNameInvalid() {
        Payment payment = new Payment(null, 100.0, new GregorianCalendar());
    }
}
