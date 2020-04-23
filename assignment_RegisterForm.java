package com.edu.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterForm {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vinuta\\IdeaProjects\\SeleniumMaven\\src\\main\\resources\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("http://newtours.demoaut.com/");
    }

    @Test
    public void regForm() {

        driver.findElement(By.xpath("//td/a[contains(@href,'mercuryregister.php')]")).click();

        //input to the form .sendkey();

        driver.findElement(By.name("firstName")).sendKeys("Anu");
        driver.findElement(By.name("lastName")).sendKeys("Henry");
        driver.findElement(By.name("phone")).sendKeys("98745613");
        driver.findElement(By.name("userName")).sendKeys("Anu@gmail.com");

        driver.findElement(By.name("address1")).sendKeys("#23, wolf road");
        driver.findElement(By.name("city")).sendKeys("Santa Clara");
        driver.findElement(By.name("state")).sendKeys("CA");
        driver.findElement(By.name("postalCode")).sendKeys("postalCode");

        //Step to perform selction from dropdowm.

        WebElement multiselect = driver.findElement(By.name("country"));
        Select multidrop = new Select(multiselect);

        multidrop.selectByValue("215");


        driver.findElement(By.name("email")).sendKeys("Henry");
        driver.findElement(By.name("password")).sendKeys("abcd12");
        driver.findElement(By.name("confirmPassword")).sendKeys("abcd12");

        //Perform submit()

        //org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document
        //so used  wait.until(ExpectedConditions.presenceOfElementLocated

        WebDriverWait wait =new WebDriverWait(driver,30);

        WebElement esubmit = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='register']")));

        esubmit.submit();



        WebElement msgElement = driver.findElement(By.xpath("//*[contains(text(),'Anu Henry')]"));

        WebElement msgElement1 = driver.findElement(By.xpath( "//*[contains(text(),'Note:')]"));

        Assert.assertEquals(msgElement.getText(),"Dear Anu Henry,");
        System.out.println(msgElement.getText() +" Thank you for registering. "+msgElement1.getText());


    }


    @AfterMethod

    public void teardown() {
       driver.close();
    }
}