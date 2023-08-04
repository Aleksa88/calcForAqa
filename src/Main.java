import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 2 числа и арифметическое действие");
        String input = scanner.nextLine();
        try {
            String result = calc(input);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("throws Exception");
        }
    }

    public static String calc(String input) throws Exception {
        String[] tokens = input.split(" ");
        if (tokens.length != 3) {
            throw new Exception();
        }
        int a, b;
        try {
            a = parseNumber(tokens[0]);
            b = parseNumber(tokens[2]);
        } catch (Exception e) {
            throw new Exception();
        }
        String operator = tokens[1];
        int result;
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    throw new Exception();
                }
                result = a / b;
                break;
            default:
                throw new Exception();
        }
        return String.valueOf(result);
    }

    public static int parseNumber(String token) throws Exception {
        int number;
        try {
            number = Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new Exception();
        }
        if (number < 1 || number > 10) {
            throw new Exception();
        }
        return number;
    }
}