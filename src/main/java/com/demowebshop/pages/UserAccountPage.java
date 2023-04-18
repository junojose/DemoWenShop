package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.utilities.TestHelperUtility;

public class UserAccountPage extends TestHelperUtility {
	public WebDriver driver;

	public UserAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private final String _validationmail = "//div[@class='header-links']//a[@class='account']";
	@FindBy(xpath = _validationmail)
	private WebElement validationmail;
	private final String _useremail = "//a[text()='jun123@gmail.com']";
	@FindBy(xpath = _useremail)
	private WebElement useremail;

	public String getusermail() {
		String email = page.getElementText(validationmail);
		return email;
	}
	public String getuseremail() {
		String uemail = page.getElementText(useremail);
		return uemail;
	}
}
