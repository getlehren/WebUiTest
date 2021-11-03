package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Selenium {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);

        driver.get("https://notalone.tv");
        driver.findElement(By.xpath("//span//a[.=\"Авторизация\"]")).click();

        driver.findElement(By.xpath("//input[@name=\"login\"]")).sendKeys("Student2021test2021");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("student2021");
        driver.findElement(By.xpath("//form[@id=\"auth_new\"]//button")).click();
        Thread.sleep(3000);

        actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(), \"Совместный просмотр\")]"))).build().perform();
        driver.findElement(By.xpath("//a[contains(text(), \"Создать новую комнату\")]")).click();

        driver.findElement(By.xpath("//form[@class=\"search_row\"]/input")).sendKeys("Идиократия");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class=\"top\"]//button[contains(text(), \"Источник\")]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class=\"singleRight\"]")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[contains(text(), \"Удалить\")]")).click();
        driver.findElement(By.xpath("//button[@type=\"button\" and contains(text(), \"удалить\")]")).click();
        driver.quit();
    }
}
