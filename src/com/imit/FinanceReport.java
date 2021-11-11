package com.imit;

import java.util.Arrays;
import java.util.Objects;

// todo: add test
public class FinanceReport {
    private final Payment[] arr;

    public String getName() {
        return name;
    }

    private final String name;

    // TODO: to Date class
    private final int year;
    private final int month;
    private final int day;

    public FinanceReport(String name, int year, int month, int day, Payment... arr) {
        if (year < 0) throw new IllegalArgumentException("...");
        if (month > 12 || month < 1) throw new IllegalArgumentException();
        if (day < 1 || day > 31) throw new IllegalArgumentException();

        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
        this.arr = arr;
    }

    public static void main(String[] args) {
        FinanceReport financeReport = new FinanceReport("Олег", 2002, 9, 24,
                new Payment("Oleg", 2020, 12, 9, 5.2),
                new Payment("Igor", 2010, 11, 10, 10.2));

        FinanceReport financeReport1 = financeReport.copy();
        financeReport1.setPayment(0, new Payment("Арсений", 2070, 11, 25, 10.2));


        System.out.println(financeReport);
        System.out.println(financeReport1);
    }

    private void checkIndex(int index) {
        if (index < 0) throw new IndexOutOfBoundsException();
        if (this.arr == null || this.arr.length <= index) throw new IndexOutOfBoundsException();
    }

    public int getCount() {
        return arr.length;
    }

    public Payment getPayment(int index) {
        checkIndex(index);
        return arr[index];
    }

    public void setPayment(int index, Payment payment) {
        checkIndex(index);
        arr[index] = payment;
    }

    @Override
    public String toString() {
        // todo: add string formatter
        return "[Автор: " + name + ", Дата: " + day + "." + month + "." + year + ", Платежи: "
                + Arrays.toString(arr) + "\n]";
    }

    private Payment[] arrayCopy(Payment[] arr) {
        if (arr == null) return null;

        Payment[] arrayNew = new Payment[arr.length];

        System.arraycopy(this.arr, 0, arrayNew, 0, arrayNew.length);

        return arrayNew;
    }

    public FinanceReport copy() {
        return new FinanceReport(this.name, this.year, this.month, this.day, arrayCopy(this.arr));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinanceReport that = (FinanceReport) o;
        return year == that.year && month == that.month && day == that.day && Arrays.equals(arr, that.arr) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, year, month, day);
        result = 31 * result + Arrays.hashCode(arr);
        return result;
    }
}