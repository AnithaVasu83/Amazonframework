package org.anitha.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.anitha.base.DriverFactory;

public class LoginPage {

    private WebDriver driver;

       @FindBy(id = "Email")
        private WebElement emailField;

        @FindBy(id = "Password")
        private WebElement passwordField;

        @FindBy(xpath = "//button[text()='Log in']")
        private WebElement loginButton;

        public LoginPage() {
            this.driver = DriverFactory.getDriver(); // ThreadLocal-safe
            PageFactory.initElements(driver, this);
        }

        public void login(String email, String password) {
            emailField.sendKeys(email);
            passwordField.sendKeys(password);
            loginButton.click();
        }
    }


