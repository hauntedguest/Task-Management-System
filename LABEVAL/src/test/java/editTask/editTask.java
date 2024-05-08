package editTask;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class editTask {
	private WebDriver driver;

    public editTask(WebDriver driver) {
        this.driver = driver;
    }

    public void eTask(String title,String description) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("http://localhost:5173");

        WebElement editT = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div[2]/svg[1]/path[2]"));
        editT.click();
        

        WebElement Title = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[1]/input"));
        Title.sendKeys(title);

        

        WebElement descrip = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/input"));
        descrip.sendKeys(description);

        

        WebElement CreteTaskElement = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]"));
        CreteTaskElement.click();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
            WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("errorMessage")));
            String reactErrorMsg = errorMessageElement.getText();
            System.out.println("Error: " + reactErrorMsg);
        } catch (Exception e) {
            System.out.println("Task Created Successfully");
        }
    }

}
