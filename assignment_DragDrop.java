package com.edu.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DragDrop {

    WebDriver driver;

    @BeforeMethod

    public void setup(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Vinuta\\IdeaProjects\\SeleniumMaven\\src\\main\\resources\\chromedriver.exe");

        driver= new ChromeDriver();

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void dragDropTest(){

        WebElement eBox1=driver.findElement(By.id("box1"));
        WebElement eBox2=driver.findElement(By.id("box2"));
        WebElement eBox3=driver.findElement(By.id("box3"));
        WebElement eBox4=driver.findElement(By.id("box4"));
        WebElement eBox5=driver.findElement(By.id("box5"));
        WebElement eBox6=driver.findElement(By.id("box6"));
        WebElement eBox7=driver.findElement(By.id("box7"));

        WebElement eBox101=driver.findElement(By.id("box101"));
        WebElement eBox102=driver.findElement(By.id("box102"));
        WebElement eBox103=driver.findElement(By.id("box103"));
        WebElement eBox104=driver.findElement(By.id("box104"));
        WebElement eBox105=driver.findElement(By.id("box105"));
        WebElement eBox106=driver.findElement(By.id("box106"));
        WebElement eBox107=driver.findElement(By.id("box107"));

        Actions action = new Actions(driver);

        action.dragAndDrop(eBox1,eBox101).build().perform();
        action.dragAndDrop(eBox2,eBox102).build().perform();
        action.dragAndDrop(eBox3,eBox103).build().perform();
        action.dragAndDrop(eBox4,eBox104).build().perform();
        action.dragAndDrop(eBox5,eBox105).build().perform();
        action.dragAndDrop(eBox6,eBox106).build().perform();
        action.dragAndDrop(eBox7,eBox107).build().perform();




    }

    @AfterMethod

    public void tearDown(){

        driver.close();
    }

}
