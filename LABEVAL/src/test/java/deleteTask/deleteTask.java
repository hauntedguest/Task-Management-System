package deleteTask;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class deleteTask {
	private WebDriver driver;

    public deleteTask(WebDriver driver) {
        this.driver = driver;
    }

    public void dTask() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://localhost:5173");

        try {
            // Wait for the delete button to be clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div[2]/svg[2]/path[1]")));
            deleteButton.click();

            // Wait for success message or error message
            WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("errorMessage")));
            String reactErrorMsg = errorMessageElement.getText();
            if (!reactErrorMsg.isEmpty()) {
                System.out.println("Error: " + reactErrorMsg);
            } else {
                System.out.println("Task Deleted Successfully");
            }
        } catch (Exception e) {
            System.out.println("Error: Task Deletion Failed - " + e.getMessage());
        }
    }

}

