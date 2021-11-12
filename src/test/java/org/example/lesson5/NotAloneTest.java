package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.lesson6.LoginPage;
import org.example.lesson6.MainPage;
import org.example.lesson6.RoomPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NotAloneTest {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;


    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void beforeEach() {
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
        driver.get("https://notalone.tv");
    }

    @AfterEach
    void afterEach() {
        driver.quit();
    }

    @Test
    void testHappyLogin() throws InterruptedException {
        login("Student2021test2021", "student2021");

        wait.until(ExpectedConditions.invisibilityOf(new LoginPage(driver).getLoginField()));
        WebElement element = new LoginPage(driver).getAuthorizationSuccessWindow();

        assertEquals("Авторизация прошла успешно!\n" + "Переадресация..", element.getText());
    }

    @Test
    void testUnHappyLogin() throws InterruptedException {
        login("Student2021test2021", "RANDOM_PASSWORD");

        wait.until(ExpectedConditions.visibilityOf(new LoginPage(driver).getAuthorizationFailedWindow()));
        WebElement element = new LoginPage(driver).getAuthorizationFailedWindow();

        assertEquals("Пользователь не найден. Возможно, неверный пароль или Вы пытаетесь ввести никнейм вместо логина.", element.getText());
    }

    @Test
    void testCreateRoom() {
        login("Student2021test2021", "student2021");

        new MainPage(driver)
                .moveToElement("Совместный просмотр")
                .clickCreateRoomInDropdown();

        WebElement deleteButton = new RoomPage(driver).getDeleteButton();
        WebElement shareRoom = new RoomPage(driver).getShareRoomHeader();

        assertNotNull(deleteButton, "Нет кнопки удаления комнаты");
        assertNotNull(shareRoom, "Нет меню Поделиться комнатой");
    }

    private void login(String username, String password) {
        new MainPage(driver)
                .clickAuthorizationButton();

        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickSubmit();
    }
}
