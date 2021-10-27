import java.util.Objects;

//todo: add tests
public class Payment {

    private String name;
    private int year;
    private int month;
    private int day;
    private double sum;

    // todo: copy construct
    public Payment(String name, int year, int month, int day, double sum) {
        if (year < 0) throw new IllegalArgumentException();
        if (month > 12 || month < 1) throw new IllegalArgumentException();
        if (day < 1 || day > 31) throw new IllegalArgumentException();

        this.name = name; // Todo: not null
        this.year = year;
        this.month = month;
        this.day = day;
        this.sum = sum; // TODO: != 0
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
        if (year < 0) throw new IllegalArgumentException();
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        // TODO: reuse in constructor
        if (month > 12 || month < 1) throw new IllegalArgumentException();
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day < 1 || day > 31) throw new IllegalArgumentException();
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
        // TODO: use string format
        // TODO: kopeyki
        return "Плательщик: " + name + ", Дата: " + day + "." + month + "." + year + ", Сумма: " + sum;
    }
}