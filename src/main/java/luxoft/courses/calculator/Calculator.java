package luxoft.courses.calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        System.out.println("Введите выражение из двух чисел для того, чтобы его вычислить");
        Calculator calculator = new Calculator();
        calculator.run();
    }

    public double calculateExpressions(String userInput) {

        double userOutput;

        if (isFactorial(userInput)) {
            userOutput = calculateFactorial(userInput);
        } else {
            userOutput = calculateExpression(userInput);
        }
        return userOutput;
    }

    public boolean isFactorial(String userInput) {
        return userInput.contains("!");
    }

    public int calculateFactorial(String userInput) {
        String cleanVariable = userInput.replace("!", "");
        int number = Integer.parseInt(cleanVariable);
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result = result * i;
        }
        return result;
    }

    public double calculateExpression(String userInput) {
        double result;
        if (userInput.contains("+")) {
            String[] cleanVariables = userInput.split("\\+");
            int number1 = Integer.parseInt(cleanVariables[0].replace(" ", ""));
            int number2 = Integer.parseInt(cleanVariables[1].replace(" ", ""));
            result = number1 + number2;
        } else if (userInput.contains("-")) {
            String[] cleanVariables = userInput.split("-");
            int number1 = Integer.parseInt(cleanVariables[0].replace(" ", ""));
            int number2 = Integer.parseInt(cleanVariables[1].replace(" ", ""));
            result = number1 - number2;
        } else if (userInput.contains("*")) {
            String[] cleanVariables = userInput.split("\\*");
            int number1 = Integer.parseInt(cleanVariables[0].replace(" ", ""));
            int number2 = Integer.parseInt(cleanVariables[1].replace(" ", ""));
            result = number1 * number2;
        } else {
            String[] cleanVariables = userInput.split("/");
            int number1 = Integer.parseInt(cleanVariables[0].replace(" ", ""));
            int number2 = Integer.parseInt(cleanVariables[1].replace(" ", ""));
            result = ((double) number1) / number2;
        }
        return result;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        while (!inputString.equals("q")) {
            double outputVariable = calculateExpressions(inputString);
            System.out.println(outputVariable);
            System.out.println("Еще раз введите выражение для того, чтобы его вычислить, или введите 'q' для выхода");
            inputString = scanner.nextLine();
        }
    }
}
