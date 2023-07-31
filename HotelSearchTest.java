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

public class HotelSearchTest extends BaseTest{

    @Test
    public void searchHotel () {

        //Wybór miasta
        driver.findElement(By.xpath("//span[text()='Search by Hotel or City Name']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Dubai");
        driver.findElement(By.xpath("//span[@class='select2-match' and text()='Dubai']")).click();

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
        Child.sendKeys("1");

        //Search
        //driver.findElement(By.cssSelector("[type='submit']")).click();
        driver.findElement(By.xpath("//button[text()=' Search']")).click();

        //Lista Hoteli
        List<String> hotelNames = driver.findElements(By.xpath("//h4[contains(@class,'list_title')]//b"))
                //.stream().map(el -> el.getText()).collect(Collectors.toList());
                .stream().map(el -> el.getAttribute("textContent")).collect(Collectors.toList());

        hotelNames.forEach(System.out::println);

        Assert.assertEquals("Jumeirah Beach Hotel",hotelNames.get(0));
        Assert.assertEquals("Oasis Beach Tower",hotelNames.get(1));
        Assert.assertEquals("Rose Rayhaan Rotana",hotelNames.get(2));
        Assert.assertEquals("Hyatt Regency Perth",hotelNames.get(3));

    }
}






