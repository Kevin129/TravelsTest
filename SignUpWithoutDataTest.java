package TravelsTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SignUpWithoutDataTest extends BaseTest{
    @Test
    public void wrongEmail () {


        driver.findElements(By.xpath("//li[@id='li_myaccount']")).
                stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);

        driver.findElements(By.xpath("//a[text()='  Sign Up']")).get(1).click();

        driver.findElement(By.name("firstname")).sendKeys("Jan");
        driver.findElement(By.name("lastname")).sendKeys("Kowalski");
        driver.findElement(By.name("phone")).sendKeys("123456789");
        driver.findElement(By.name("email")).sendKeys("Jan700460.pl");
        driver.findElement(By.name("password")).sendKeys("Test1234");
        driver.findElement(By.name("confirmpassword")).sendKeys("Test1234");

        //ClickSignUp
        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();

        List<String> errors = driver.findElements(By.xpath("//div[@class='alert alert-danger']//p")).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        Assert.assertTrue(errors.contains("The Email field must contain a valid email address."));
    }
}
