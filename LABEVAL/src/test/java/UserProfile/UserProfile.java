package UserProfile;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserProfile{
	private WebDriver driver;

    public UserProfile(WebDriver driver) {
        this.driver = driver;
    }

    public void profile() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("http://localhost:5173");
        WebElement profileButton = driver.findElement(By.xpath("//*[@id=\"basic-navbar-nav\"]/div/a[2]"));
        profileButton.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
            WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("errorMessage")));
            String reactErrorMsg = errorMessageElement.getText();
            System.out.println("Error: " + reactErrorMsg);
        } catch (Exception e) {
            System.out.println("User Profile Successfully");
        }
    }

}

