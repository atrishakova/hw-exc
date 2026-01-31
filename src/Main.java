import ru.netology.PasswordChecker.PasswordChecker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите мин. длину пароля: ");
        int minLength = scanner.nextInt();

        System.out.print("Введите макс. допустимое количество повторений символа подряд: ");
        int maxCountRepeats = scanner.nextInt();

        PasswordChecker passwordChecker = new PasswordChecker();

        passwordChecker.setMaxRepeats(maxCountRepeats);
        passwordChecker.setMinLength(minLength);

        while (true) {
            System.out.print("Введите пароль или end: ");
            String input = scanner.next();

            if (input.equals("end")) {
                System.out.println("Программа завершена");
                break;
            }

            System.out.println(passwordChecker.verify(input) ? "Подходит!" : "Не подходит!");
        }

        scanner.close();
    }
}
