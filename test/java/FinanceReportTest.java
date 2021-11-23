import com.imit.FinanceReport;
import com.imit.Payment;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.testng.Assert.assertNotEquals;

public class FinanceReportTest {
    FinanceReport financeReport = new FinanceReport("Sergey", new GregorianCalendar(2021, Calendar.FEBRUARY, 10),
            new Payment("Pyaterochka", 100.2, new GregorianCalendar(2010, Calendar.FEBRUARY, 20)),
            new Payment("Magnit", 99.99, new GregorianCalendar(2019, Calendar.MARCH, 2)),
            new Payment("Perekrestok", 1.2, new GregorianCalendar(2020, Calendar.JANUARY, 1)));

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testInvalidIndex() {
        financeReport.getPayment(financeReport.getArr().length + 100);
    }

    @Test
    public void testCopy() {
        FinanceReport copy = new FinanceReport(financeReport);
        copy.setPayment(0, new Payment("name", 10.1, new GregorianCalendar()));
        assertNotEquals(copy.getPayment(0), financeReport.getPayment(0));
    }
}
