package register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class register {

    private WebDriver driver;

    public register(WebDriver driver) {
        this.driver = driver;
    }

    public void Register(String fullName, Integer phoneNumber, String email, String password, String path) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("http://localhost:5173/login");

        WebElement registerButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/form/div[3]/label/a"));
        registerButton.click();
        

        WebElement username = driver.findElement(By.xpath("//*[@id=\"formBasicEmail\"]"));
        username.sendKeys(fullName);

        WebElement phoneNumberElement = driver.findElement(By.id("phone"));
        phoneNumberElement.sendKeys(String.valueOf(phoneNumber));

//        WebElement cityElement = driver.findElement(By.name("city"));
//        cityElement.sendKeys(city);

        WebElement emailElement = driver.findElement(By.id("email"));
        emailElement.sendKeys(email);

        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys(password);
        
        WebElement imgpath = driver.findElement(By.id("img"));
        imgpath.sendKeys(path);

        WebElement registerButtonElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/form/button"));
        registerButtonElement.click();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("errorMessage")));
            String reactErrorMsg = errorMessageElement.getText();
            System.out.println("Error: " + reactErrorMsg);
        } catch (Exception e) {
            System.out.println("Registration successful");
        }
    }
}