import ru.netology.PasswordChecker.PasswordChecker;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordChecker passwordChecker = new PasswordChecker();

        try {
            System.out.print("Введите мин. длину пароля: ");
            int minLength = scanner.nextInt();

            System.out.print("Введите макс. допустимое количество повторений символа подряд: ");
            int maxCountRepeats = scanner.nextInt();

            passwordChecker.setMaxRepeats(maxCountRepeats);
            passwordChecker.setMinLength(minLength);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            while (true) {
                System.out.print("Введите пароль или end: ");
                String input = scanner.next();

                if (input.equals("end")) {
                    System.out.println("Программа завершена");
                    break;
                }

                System.out.println(passwordChecker.verify(input) ? "Подходит!" : "Не подходит!");
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
