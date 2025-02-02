package talentLMS.utils.randomEntityUtils;

import com.github.javafaker.Faker;
import talentLMS.entity.User;

import java.util.Locale;
import java.util.Random;

public class RandomUserGenerator {

    static Faker faker = new Faker(new Locale("en"));

    public static String randomFirstName() {
        return faker.name().fullName();
    }

    public String randomLastName() {
        return faker.name().lastName();
    }

    public String randomEmail() {
        return faker.internet().emailAddress();
    }

    public String randomUserName() {
        return faker.name().username();
    }

    public User randomUser() {
        return new User(randomFirstName(), randomLastName(), randomUserName(), randomEmail());
    }

    public static String generateStrongPassword(int length) {
        if (length < 8) {
            throw new IllegalArgumentException("Пароль должен быть не менее 8 символов");
        }

        Faker faker = new Faker();
        Random random = new Random();

        // Генерируем обязательные символы
        char upperCase = (char) ('A' + random.nextInt(26)); // Заглавная буква
        char lowerCase = (char) ('a' + random.nextInt(26)); // Строчная буква
        char digit = (char) ('0' + random.nextInt(10));     // Цифра
        String specialChars = "!@#$%^&*()_+{}[]|:;<>,.?/"; // Пример специальных символов
        char specialChar = specialChars.charAt(random.nextInt(specialChars.length()));

        // Генерируем оставшиеся символы
        StringBuilder remaining = new StringBuilder(faker.lorem().characters(length - 4));

        // Добавляем обязательные символы
        remaining.append(upperCase);
        remaining.append(lowerCase);
        remaining.append(digit);
        remaining.append(specialChar);

        // Перемешиваем символы
        return shuffleString(remaining.toString());
    }

    // Метод для перемешивания символов строки
    private static String shuffleString(String input) {
        Random random = new Random();
        char[] array = input.toCharArray();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // Swap
            char temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return new String(array);
    }
}