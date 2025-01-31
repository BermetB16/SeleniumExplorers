package talentLMS.page.users;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import talentLMS.driver.Driver;
import talentLMS.entity.User;
import talentLMS.page.BasePage;
import talentLMS.page.dashboard.DashboardPage;

import java.time.Duration;
import java.util.Random;

public class AddUserPage extends BasePage {
    @FindBy(xpath = "//input[@name = 'name']")
    public WebElement firstName;
    @FindBy(xpath = "//input[@name = 'surname']")
    public WebElement lastName;
    @FindBy(xpath = "//input[@name = 'email']")
    public WebElement email;
    @FindBy(xpath = "//input[@name='login']")
    public WebElement username;
    @FindBy(xpath = "//input[@name = 'password']")
    public WebElement password;
    @FindBy(xpath = "//input[@name ='submit_personal_details']")
    public WebElement addUserSubmitButton;

    public AddUserPage addNewUser(User user) {
        webElementActions.click(dashboardPage.addUserButton);
        webElementActions.sendKeys(firstName, user.getFirstName())
                .sendKeys(lastName, user.getLastName())
                .sendKeys(email, user.getEmail())
                .sendKeys(username, user.getUserName())
                .sendKeys(password,generateStrongPassword(10))
                .click(addUserSubmitButton);
        return this;
    }

    public AddUserPage updateInfoOfUsers(String username) {
        dashboardPage.switchToPage("Users");
        driver.findElement(By.xpath("//tr[@role='row']/td/a/span[text()='" + username + "']")).click();
        firstName.clear();
        webElementActions.sendKeys(firstName, randomUserGenerator.randomFirstName())
                .click(new AddUserPage().addUserSubmitButton);
        return this;
    }


        public String generateStrongPassword( int length){
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
        private static String shuffleString (String input){
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


