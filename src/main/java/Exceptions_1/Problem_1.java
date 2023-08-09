package Exceptions_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Problem_1 {
    public static void main(String[] args) throws InputMismatchException {
        inputNumber();
    }

    static void inputNumber() {
        System.out.println("Введите число типа float");
        Scanner scanner = new Scanner(System.in);
        try {
            Float input = Float.valueOf(scanner.nextLine());
            System.out.println("Введено число:");
            System.out.println(input);
            System.out.println("Программа отработала правильно");
        } catch (NumberFormatException ex) {
            System.out.println("Ошибка: неверный формат введенных данных");
            inputNumber();
        }

    }


}
