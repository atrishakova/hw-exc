package ru.netology.PasswordChecker;

public class PasswordChecker {
    private static final int NOT_SET = -1;
    private int minPwdLength = NOT_SET;
    private int maxCountRepeats = NOT_SET;

    public void setMinLength (int minLength) {
        if (minLength < 0) {
            throw new IllegalArgumentException("Задано отрицательное число в качестве минимальной длины пароля");
        }

        this.minPwdLength = minLength;
    }

    public void setMaxRepeats (int maxCountRepeats) {
        if (maxCountRepeats <= 0) {
            throw new IllegalArgumentException("Задано отрицательное число или 0 в качестве макс.количества повторений символа подряд");
        }

        this.maxCountRepeats = maxCountRepeats;
    }

    public boolean verify (String password) {
        if (minPwdLength == NOT_SET || maxCountRepeats == NOT_SET) {
            throw new IllegalArgumentException("Для проверки пароля должны быть заданы критерии проверки");
        }

        if (password.length() < this.minPwdLength) {
            return false;
        }

        int currentCount = 1;

        for (int i = 1; i < password.length(); i++) {
            if (password.charAt(i) == password.charAt(i - 1)) {
                currentCount++;
                if (currentCount > this.maxCountRepeats) {
                    return false;
                }
            } else {
                currentCount = 1;
            }
        }

        return true;
    }
}
