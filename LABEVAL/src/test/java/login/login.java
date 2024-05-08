package login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login {

	private WebDriver driver;

	public login(WebDriver driver) {
		this.driver = driver;
	}

	public void Login(String email, String password, boolean logout) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.get("http://localhost:5173/login");

		WebElement loginEmail = driver.findElement(By.xpath("//*[@id=\"formBasicEmail\"]"));
		loginEmail.sendKeys(email);

		WebElement loginPassword = driver.findElement(By.xpath("//*[@id=\"formBasicPassword\"]"));
		loginPassword.sendKeys(password);

		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/form/button"));
		loginButton.click();

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
			WebElement errorMessageElement = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.name("errorMessage")));
			String reactErrorMsg = errorMessageElement.getText();
			System.out.println("Error: " + reactErrorMsg);
		} catch (Exception err) {
			System.out.println("Login successful");
//			if (logout == true) {
//
//				WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"basic-navbar-nav\"]/div/button"));
//				logoutButton.click();
//			}
		}
	}
}