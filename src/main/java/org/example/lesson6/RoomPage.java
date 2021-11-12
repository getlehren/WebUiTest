package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RoomPage extends BasePage {
    public RoomPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id=\"new_player\"]")
    private WebElement playerElement;
    @FindBy(xpath = "//button[contains(text(), \"Удалить\")]")
    private WebElement deleteButton;
    @FindBy(xpath = "//h2[.=\\\"Поделиться комнатой\\\"]")
    private WebElement shareRoomHeader;

    public WebElement getPlayerElement() {
        wait.until(ExpectedConditions.visibilityOf(new RoomPage(driver).getPlayerElement()));
        return playerElement;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public WebElement getShareRoomHeader() {
        return shareRoomHeader;
    }
}
