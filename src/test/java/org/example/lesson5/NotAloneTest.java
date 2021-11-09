package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
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
    }

    @AfterEach
    void afterEach() {
        driver.quit();
    }

    @Test
    void testHappyLogin() throws InterruptedException {
        login("Student2021test2021", "student2021");

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//input[@name=\"login\"]"))));
        WebElement element = driver.findElement(By.xpath("//span[@class=\"resultBox auth_result success\"]"));

        assertEquals("Авторизация прошла успешно!\n" + "Переадресация..", element.getText());
    }

    @Test
    void testUnHappyLogin() throws InterruptedException {
        login("Student2021test2021", "RANDOM_PASSWORD");

        wait.until(d -> (d.findElement(By.xpath("//span[@class=\"resultBox auth_result error\"]"))));
        WebElement element = driver.findElement(By.xpath("//span[@class=\"resultBox auth_result error\"]"));

        assertEquals("Пользователь не найден. Возможно, неверный пароль или Вы пытаетесь ввести никнейм вместо логина.", element.getText());
    }

    @Test
    void testCreateRoom() throws InterruptedException {
        login("Student2021test2021", "student2021");

        actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(), \"Совместный просмотр\")]"))).build().perform();
        driver.findElement(By.xpath("//a[contains(text(), \"Создать новую комнату\")]")).click();

        wait.until(d -> (d.findElement(By.xpath("//div[@id=\"new_player\"]"))));
        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(text(), \"Удалить\")]"));
        WebElement shareRoom = driver.findElement(By.xpath("//h2[.=\"Поделиться комнатой\"]"));

        assertNotNull(deleteButton);
        assertNotNull(shareRoom);
    }

    private void login(String username, String password) {
        driver.get("https://notalone.tv");
        driver.findElement(By.xpath("//span//a[.=\"Авторизация\"]")).click();

        driver.findElement(By.xpath("//input[@name=\"login\"]")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//form[@id=\"auth_new\"]//button")).click();
    }
}
