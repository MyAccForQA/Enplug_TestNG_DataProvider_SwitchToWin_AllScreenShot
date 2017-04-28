package pom_pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class HomePage{
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//a[contains(text(), 'Login')]")
	private WebElement login;

	public HomePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(this.driver, this);
	}

	@Step("findAndClickLink_Login")
	public WebElement findAndClickLink_Login() {
		wait.until(ExpectedConditions.elementToBeClickable(login)).click();
		return login;
	}
}