import java.util.Scanner;

class Main {
    public static String calc(String input) {
        String[] tokens = input.split(" ");

        if (tokens.length != 3) {
            return "Некорректный ввод";
        }

        int num1, num2;
        try {
            num1 = Integer.parseInt(tokens[0]);
            num2 = Integer.parseInt(tokens[2]);
        } catch (NumberFormatException e) {
            return "Некорректный ввод";
        }

        if (num1 < 1 || num1> 10 || num2 < 1 || num2 > 10) {
            return "Некорректный ввод";
        }

        int result;
        switch (tokens[1]) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    return "Некорректный ввод";
                }
                result = num1 / num2;
                break;
            default:
                return "Некорректный ввод";
        }

        return String.valueOf(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String input = scanner.nextLine();
        System.out.println(calc(input));
        scanner.close();
    }
}
