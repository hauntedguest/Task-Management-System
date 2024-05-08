package FilterTask1;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilterTask1{
	private WebDriver driver;

    public FilterTask1(WebDriver driver) {
        this.driver = driver;
    }

    public void f1Task() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("http://localhost:5173");

        WebElement Ftask = driver.findElement(By.xpath("//*[@id=\"basic-nav-dropdown\"]"));
        Ftask.click();
        

//        WebElement Ctask = driver.findElement(By.xpath("//*[@id=\"basic-navbar-nav\"]/div/div/div/a[2]"));
//        Ctask.click();

        

        WebElement Itask = driver.findElement(By.xpath("//*[@id=\"basic-navbar-nav\"]/div/div/div/a[3]"));
        Itask.click();

        

//        WebElement Atask = driver.findElement(By.xpath("//*[@id=\"basic-navbar-nav\"]/div/div/div/a[4]"));
//        Atask.click();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
            WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("errorMessage")));
            String reactErrorMsg = errorMessageElement.getText();
            System.out.println("Error: " + reactErrorMsg);
        } catch (Exception e) {
            System.out.println("Task Filtered Successfully");
        }
    }

}
