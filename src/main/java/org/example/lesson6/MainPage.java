package org.example.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    Actions actions = new Actions(driver);

    @FindBy(xpath = "//span//a[.=\"Авторизация\"]")
    private WebElement authorizationButton;
    @FindBy(xpath = "//a[contains(text(), \"Создать новую комнату\")]")
    private WebElement createRoomDropdownMenu;

    @Step("Нажимаем на кнопку Авторизация")
    public MainPage clickAuthorizationButton() {
        authorizationButton.click();
        return this;
    }

    @Step("Наводим на элемент")
    public MainPage moveToElement(String menuElement) {
        actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(), \"" + menuElement+ "\")]")))
                .build()
                .perform();
        return this;
    }

    @Step("Нажимаем на кнопку создать новую комнату")
    public MainPage clickCreateRoomInDropdown() {
        createRoomDropdownMenu.click();
        return this;
    }
}
