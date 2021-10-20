import java.util.Calendar;
import java.util.Objects;

public class Payment {

    private String name;
    private int year;
    private int month;
    private int day;
    private double sum;

    public Payment(String name, int year, int month, int day, double sum) {
        if (year < 0) throw new ArithmeticException();
        if (month > 12 || month < 1) throw new ArithmeticException();
        if (day < 1 || day > 31) throw new ArithmeticException();

        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 0) throw new ArithmeticException();
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month > 12 || month < 1) throw new ArithmeticException();
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day < 1 || day > 31) throw new ArithmeticException();
        this.day = day;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return year == payment.year && month == payment.month && day == payment.day
                && Double.compare(payment.sum, sum) == 0 && Objects.equals(name, payment.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, month, day, sum);
    }

    @Override
    public String toString() {
        return "Плательщик: " + name + ", Дата: " + day + "." + month + "." + year + ", Сумма: " + sum;
    }

    public static void main(String[] args) {

    }
}