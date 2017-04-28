package pom_pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;

	// @FindBy(xpath = "//input[@name = 'email']")
	@FindBy(name = "email")
	private WebElement email;

	// @FindBy(xpath = "//input[@name = 'password']")
	@FindBy(name = "password")
	private WebElement password;

	// @FindBy(xpath = "//button[@type = 'submit']")
	@FindBy(xpath = "//button[@class = 'btn btn-primary btn-lg mt']")
	private WebElement buttonLogin;

	@FindBy(xpath = "//span[@class = 'ng-binding' and @ng-bind = 'error']")
	private WebElement incorrectEmail;

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(this.driver, this);
	}

	@Step("findAndFillInField_Username with user name - [{0}]")
	public WebElement findAndFillInField_Username(String st) {
		wait.until(ExpectedConditions.visibilityOf(email)).clear();
		email.sendKeys(st);
		return email;
	}

	@Step("findAndFillInField_Password with password - [{0}]")
	public WebElement findAndFillInField_Password(String st) {
		wait.until(ExpectedConditions.visibilityOf(password)).clear();
		password.sendKeys(st);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return password;
	}

	@Step("findButton_Login_isEnabled - return boolean")
	public boolean findButton_Login_isEnabled() {
		return wait.until(ExpectedConditions.visibilityOf(buttonLogin)).isEnabled();
	}

	@Step("findButton_Login_isDisplayed - return boolean")
	public boolean findButton_Login_isDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(buttonLogin)).isDisplayed();
	}

	@Step("findAndClickButton_Login")
	public WebElement findAndClickButton_Login() {
		wait.until(ExpectedConditions.visibilityOf(buttonLogin)).click();
		return buttonLogin;
	}

	@Step("find_IncorrectEmail")
	public WebElement find_IncorrectEmail() {
		wait.until(ExpectedConditions.visibilityOf(incorrectEmail));
		return incorrectEmail;
	}

	@Step("find_IncorrectEmail_Message")
	public String find_IncorrectEmail_Message() {
		wait.until(ExpectedConditions.visibilityOf(incorrectEmail));
		return incorrectEmail.getText();
	}
}