package TravelsTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NoResultsFoundTest extends BaseTest{
    @Test
    public void searchHotelNoResults () {

        //Data Przyjazdu
        driver.findElement(By.name("checkin")).sendKeys("11/09/2023");

        //Data wyjazdu
        driver.findElement(By.name("checkout")).sendKeys("16/09/2023");

        //Ilośc osób
        driver.findElement(By.id("travellersInput")).click();

        WebElement Adults = driver.findElement(By.id("adultInput"));
        Adults.clear();
        Adults.sendKeys("2");

        WebElement Child = driver.findElement(By.id("childInput"));
        Child.clear();
        Child.sendKeys("0");

        //Search
        //driver.findElement(By.cssSelector("[type='submit']")).click();
        driver.findElement(By.xpath("//button[text()=' Search']")).click();

        //Sprawdzenie nagłówka
        WebElement heading = driver.findElement(By.xpath("//h2[@class='text-center']"));

        //Pobiera teskt heading
        Assert.assertEquals(heading.getText(),"No Results Found");

    }
}
