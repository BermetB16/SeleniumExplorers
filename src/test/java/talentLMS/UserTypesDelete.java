package talentLMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class UserTypesDelete extends UserTypeTestPage {

    @Test
    public void testDeleteLoginAndPassword() {
        String username = "testUser";

        // Удаляем логин и пароль пользователя
        userTypesPage.deleteUserCredentials(username);

        // Проверяем, что поля логина и пароля пустые
        WebElement loginElement = driver.findElement(By.id("login"));
        WebElement passwordElement = driver.findElement(By.id("password"));

        assertEquals(loginElement.getAttribute("value"), "", "Логин не был удален");
        assertEquals(passwordElement.getAttribute("value"), "", "Пароль не был удален");
    }

}
