package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.utilities.TestHelperUtility;
import com.demowebshop.utilities.WaitUtility;

public class LoginPage extends TestHelperUtility {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private final String _emailField = "//input[@id='Email']";
	@FindBy(xpath = _emailField)
	private WebElement emailField;
	private final String _passwordField = "//input[@id='Password']";
	@FindBy(xpath = _passwordField)
	private WebElement passwordField;
	private final String _logInButton = "//input[@value='Log in']";
	@FindBy(xpath = _logInButton)
	private WebElement logInButton;
	private final String _errorMessage = "//span[text()='Login was unsuccessful. Please correct the errors and try again.']";
	@FindBy(xpath = _errorMessage)
	private WebElement errorMessage;

	public String loginPageTitle() {
		String title = page.getPageTitle(driver);
		return title;
	}

	public void enterEmail(String emailId) {
		page.enterText(emailField, emailId);
	}

	public void enterPassword(String pswd) {
		page.enterText(passwordField, pswd);
	}

	public void clickOnLoginButton() {
		page.clickOnElement(logInButton);
	}

	public String getErrorMessage() {
		wait.setHardWait();
		wait.waitForElementToBeVisible(driver, _errorMessage, WaitUtility.LocatorType.Xpath);
		String errMessage = page.getElementText(errorMessage);
		return errMessage;
	}

	public UserAccountPage clickLoginButton() {
		page.clickOnElement(logInButton);
		return new UserAccountPage(driver);
	}

}
