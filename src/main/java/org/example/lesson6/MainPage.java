package org.example.lesson6;

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

    public MainPage clickAuthorizationButton() {
        authorizationButton.click();
        return this;
    }

    public MainPage moveToElement(String menuElement) {
        actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(), \"" + menuElement+ "\")]")))
                .build()
                .perform();
        return this;
    }

    public MainPage clickCreateRoomInDropdown() {
        createRoomDropdownMenu.click();
        return this;
    }
}
