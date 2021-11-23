package com.imit;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class FinanceReportProcessor {

    public static FinanceReport getReport(FinanceReport financeReport, String begin) {
        GregorianCalendar calendar = new GregorianCalendar();

        ArrayList<Payment> arrayList = new ArrayList<>();
        for (int i = 0; i < financeReport.getCount(); i++) {
            if (financeReport.getPayment(i).getName().startsWith(begin)) {
                arrayList.add(financeReport.getPayment(i));
            }
        }

        return new FinanceReport(financeReport.getName(), calendar, arrayList.toArray(new Payment[0]));
    }

    public static FinanceReport getPayment(FinanceReport financeReport, double sumMax) {
        GregorianCalendar calendar = new GregorianCalendar();

        ArrayList<Payment> arrayList = new ArrayList<>();
        for (int i = 0; i < financeReport.getCount(); i++) {
            if (financeReport.getPayment(i).getSum() < sumMax) {
                arrayList.add(financeReport.getPayment(i));
            }
        }
        return new FinanceReport(financeReport.getName(), calendar, arrayList.toArray(new Payment[0]));
    }
}