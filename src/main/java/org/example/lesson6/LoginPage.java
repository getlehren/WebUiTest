package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name=\"login\"]")
    private WebElement loginField;
    @FindBy(xpath = "//input[@name=\"password\"]")
    private WebElement passwordField;
    @FindBy(xpath = "//form[@id=\"auth_new\"]//button")
    private WebElement authButtonSubmit;

    @FindBy(xpath = "//span[@class=\"resultBox auth_result success\"]")
    private WebElement authorizationSuccessWindow;
    @FindBy(xpath = "//span[@class=\"resultBox auth_result error\"]")
    private WebElement authorizationFailedWindow;

    public LoginPage enterLogin(String login) {
        loginField.sendKeys(login);

        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.sendKeys(password);

        return this;
    }

    public LoginPage clickSubmit() {
        authButtonSubmit.click();
        return this;
    }

    public WebElement getAuthorizationSuccessWindow() {
        return authorizationSuccessWindow;
    }

    public WebElement getAuthorizationFailedWindow() {
        return authorizationFailedWindow;
    }

    public WebElement getLoginField() {
        return loginField;
    }
}
