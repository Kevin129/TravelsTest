package TravelsTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SignUpTest extends BaseTest{
    @Test
    public void signUp () {
        String firstName = "Jan";
        String lastName = "Kowalski";

        //Random email
        int randomNumber = (int) (Math.random() * 1000);
        String email = "Jan" + randomNumber + "@gmail.com";

        driver.findElements(By.xpath("//li[@id='li_myaccount']")).stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        driver.findElements(By.xpath("//a[text()='  Sign Up']")).get(1).click();

        //Completing the form
        /*driver.findElement(By.xpath("//input[@class='form-control' and @type='text' and @name='firstname']")).sendKeys("Jan");
        driver.findElement(By.xpath("//input[@class='form-control' and @type='text' and @name='lastname']")).sendKeys("Kowalski");
        driver.findElement(By.xpath("//input[@class='form-control' and @type='text' and @name='phone']")).sendKeys("123456789");
        driver.findElement(By.xpath("//input[@class='form-control' and @type='text' and @name='email']")).sendKeys("jan700460@gmail.com");
        driver.findElement(By.xpath("//input[@class='form-control' and @type='password' and @name='password']")).sendKeys("Test1234");
        driver.findElement(By.xpath("//input[@class='form-control' and @type='password' and @name='confirmpassword']")).sendKeys("Test1234");*/


        driver.findElement(By.name("firstname")).sendKeys(firstName);
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.name("phone")).sendKeys("123456789");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("Test1234");
        driver.findElement(By.name("confirmpassword")).sendKeys("Test1234");

        //ClickSignUp
        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();

        //Sprawdzenie nagłówka
        WebElement heading = driver.findElement(By.xpath("//h3[@class='RTL']"));
        Assert.assertTrue(heading.getText().contains(firstName));
        Assert.assertTrue(heading.getText().contains(lastName));
        //Pobiera teskt heading
        Assert.assertEquals(heading.getText(), "Hi, Jan Kowalski");
    }
}








