package com.imit.tasks.first;

public class SimpleTasks {
    public static double[] fourthTask(double a, double b, double c) throws IllegalArgumentException {
        double det = b * b - 4 * a * c;

        if (Double.compare(a, 0.0) == 0) {
            throw new IllegalArgumentException("Argument is zero");
        }
        if (Double.compare(det, 0) > 0) {
            return new double[]{(-b + Math.sqrt(det)) / (2 * a),
                    (-b - Math.sqrt(det)) / (2 * a)};
        }
        if (Double.compare(det, 0) == 0) {
            return new double[]{(-b / (2 * a))};
        }
        return new double[0];
    }

    public static void fifthTask(double l, double r, double step) {
        if (Double.compare(step, 0.0) == 0) {
            throw new IllegalArgumentException("Step is zero!");
        }
        if (Double.compare(step, 0.0) < 0) {
            if (l > r) {
                for (double argument = l; argument >= r; argument += step) {
                    System.out.println(argument + "   " + Math.sin(argument));
                }
            } else {
                throw new IllegalArgumentException();
            }
        }

        if (Double.compare(step, 0.0) > 0) {
            if (l < r) {
                for (double argument = l; argument < r + step / 2; argument += step) {
                    System.out.println(argument + "   " + Math.sin(argument));
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public static double[] sixthTask(double a1, double b1, double c1, double a2, double b2, double c2) {
        double x, y;
        double det = a1 * b2 - b1 * a2;
        if (det == 0) {
            if (a1 != 0 && a2 != 0 && b1 == 0) {
                if (c1 / a1 == c2 / a2) {
                    System.out.println("Бесконечно много решений");
                } else {
                    System.out.println("Нет корней");
                }
            }

            if (b1 != 0 && b2 != 0 && a1 == 0) {
                if (c1 / b1 == c2 / b2) {
                    System.out.println("Бесконечно много решений");
                } else {
                    System.out.println("Нет корней");
                }
            }

            if (a1 != 0 && b1 != 0 && a2 == 0) {
                if (c2 == 0) {
                    System.out.println("Бесконечно много решений");
                } else {
                    System.out.println("Нет корней");
                }
            }

            if (a2 != 0 && b2 != 0 && a1 == 0) {
                if (c1 == 0) {
                    System.out.println("Бесконечно много решений");
                } else {
                    System.out.println("Нет корней");
                }
            }

            if (a1 != 0 && b2 != 0 && a2 != 0 && b1 != 0) {
                if (a1 * b2 == a2 * b1) {
                    if (c1 * b2 == c2 * b1) {
                        System.out.println("Бесконечно много решений");
                    } else {
                        System.out.println("Нет корней");
                    }
                }
            }

            if (a1 == 0 && b2 == 0 && a2 == 0 && b1 == 0) {
                if (c1 == 0 && c2 == 0) {
                    System.out.println("Бесконечно много решений");
                } else {
                    System.out.println("Нет корней");
                }
            }
        } else {
            return new double[]{(c1 * b2 - b1 * c2) / det, (a1 * c2 - c1 * a2) / det};
        }
        return new double[0];
    }

    public static double seventhTask(double x, double eps) {
        double result = 1.0;
        int counter = 1;
        double temp = x;
        while (Double.compare(Math.abs(temp), eps) >= 0) {
            result += temp;

            counter++;
            temp *= x / counter;
        }
        return result;
    }
}