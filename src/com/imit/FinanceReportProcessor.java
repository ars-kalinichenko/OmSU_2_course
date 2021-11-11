package com.imit;

import java.util.ArrayList;
import java.util.Calendar;

//add test
public class FinanceReportProcessor {

    public static FinanceReport getReport(FinanceReport financeReport, String begin) {
        Calendar calendar = Calendar.getInstance();

        ArrayList<Payment> arrayList = new ArrayList<>();
        for (int i = 0; i < financeReport.getCount(); i++) {
            if (financeReport.getPayment(i).getName().startsWith(begin)) {
                arrayList.add(financeReport.getPayment(i));
            }
        }

        Payment[] payments = new Payment[arrayList.size()];
        int index = 0;
        for (Payment payment : arrayList) {
            payments[index] = payment;
            index++;
        }
        return new FinanceReport(financeReport.getName(), calendar.get(Calendar.YEAR) - 1900,
                calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), payments);
    }

    public static FinanceReport getPayment(FinanceReport financeReport, double sumMax) {
        Calendar calendar = Calendar.getInstance();

        ArrayList<Payment> arrayList = new ArrayList<>();
        for (int i = 0; i < financeReport.getCount(); i++) {
            if (financeReport.getPayment(i).getSum() < sumMax) {
                arrayList.add(financeReport.getPayment(i));
            };
        }

        Payment[] payments = new Payment[arrayList.size()];
        int index = 0;
        for (Payment payment : arrayList) {
            //todo: link to copy
            payments[index] = payment;
            index++;
        }
        return new FinanceReport(financeReport.getName(), calendar.get(Calendar.YEAR) - 1900,
                calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), payments);
    }

    public static void main(String[] args) {
        FinanceReport financeReport = new FinanceReport("Sergey", 2002, 9, 24,
                new Payment("Oleg", 2020, 12, 9, 1.2),
                new Payment("Olia", 2020, 12, 9, 5.2),
                new Payment("Ivan", 2020, 12, 9, 13.7),
                new Payment("Ooo", 2020, 12, 9, 82.9),
                new Payment("Sergey", 2020, 12, 9, 150.4),
                new Payment("Igor", 2010, 11, 10, 256.6));

        System.out.println(getReport(financeReport, "O"));
        System.out.println(getPayment(financeReport, -1));
    }
}