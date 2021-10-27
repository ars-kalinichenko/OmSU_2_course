public class StringProcessor {
    public static String multiply(String str, int n) {
        if (str == null) throw new NullPointerException("field str can't be null");
        if (n < 0) throw new ArithmeticException("n < 0");
        if (n == 0) return "";

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) stringBuilder.append(str);

        return stringBuilder.toString();
    }

    public static int contains(String str1, String str2) {
        if (str1 == null || str2 == null || str2.isEmpty()) throw new NullPointerException("Can't be empty");
        if (str1.length() < str2.length()) throw new ArithmeticException("Length error");

        int res = 0;

        for (int i = 0; i <= str1.length() - str2.length(); i++) {
            if (str2.equals(str1.subSequence(i, str2.length() + i).toString())) res++;
        }

        return res;
    }

    public static String newString(String str) {
        if (str == null) throw new NullPointerException("str can't be null");
        if (str.isEmpty()) return "";

        while (str.contains("1")) {
            str = str.replace("1", "один");
        }

        while (str.contains("2")) {
            str = str.replace("2", "два");
        }

        while (str.contains("3")) {
            str = str.replace("3", "три");
        }
        return str;
    }

    public static void redactStringBuilder(StringBuilder stringBuilder) {
        if (stringBuilder == null || stringBuilder.length() < 2) return;

        int size = stringBuilder.length();

        for (int i = 1; i < size; i++) {
            if (i >= stringBuilder.length()) return;
            stringBuilder.deleteCharAt(i);
        }
    }

    public static void main(String[] args) {
        System.out.println(multiply("Hello", 0));
        System.out.println(contains("abcadababababab", "j"));
        System.out.println(newString("this is 11 \nthis is 222\nthis is 3"));

        StringBuilder stringBuilder = new StringBuilder("ab");
        redactStringBuilder(stringBuilder);
        System.out.println(stringBuilder);
    }
}