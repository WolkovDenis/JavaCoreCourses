package reflection;


public class Calculator {

    public void sum(int a, int b) {
        int res = a + b;
        System.out.println("сумма" + " " + a + " " + "и" + " " + b + " = " + res);
    }

    public void subtraction(int a, int b) {
        int res = a - b;
        System.out.println("разница" + " " + a + " " + "и" + " " + b + " = " + res);
    }

    public void multiplication(int a, int b) {
        int res = a * b;
        System.out.println("умножение" + " " + a + " " + "и" + " " + b + " = " + res);
    }

    public void division(int a, int b) {
        int res = a / b;
        System.out.println("деление" + " " + a + " " + "и" + " " + b + " = " + res);
    }
}
