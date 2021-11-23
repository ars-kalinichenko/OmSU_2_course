import com.imit.FinanceReport;
import com.imit.FinanceReportProcessor;
import com.imit.Payment;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.testng.AssertJUnit.assertEquals;

public class FinanceReportProcessorTest {
    FinanceReport financeReport = new FinanceReport("Sergey", new GregorianCalendar(2021, Calendar.FEBRUARY, 10),
            new Payment("Pyaterochka", 100.2, new GregorianCalendar(2010, Calendar.FEBRUARY, 20)),
            new Payment("Magnit", 99.99, new GregorianCalendar(2019, Calendar.MARCH, 2)),
            new Payment("Perekrestok", 1.2, new GregorianCalendar(2020, Calendar.JANUARY, 1)));

    @Test
    public void testFilterByPrefix() {
        FinanceReport result1 = FinanceReportProcessor.getReport(financeReport, "P");
        assertEquals(result1.getArr().length, 2);
        FinanceReport result2 = FinanceReportProcessor.getReport(financeReport, "xxxxx");
        assertEquals(result2.getArr().length, 0);
    }

    @Test
    public void testFilterByLimit() {
        FinanceReport result = FinanceReportProcessor.getPayment(financeReport, 10);
        assertEquals(result.getArr().length, 1);
    }
}
