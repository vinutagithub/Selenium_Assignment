package com.edu.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class EmployeeList {
    WebDriver driver;

    @BeforeMethod
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vinuta\\IdeaProjects\\SeleniumMaven\\src\\main\\resources\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");


    }

    @Test

    public void empList(){

        driver.findElement(By.id("txtUsername")).sendKeys("admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();

        WebElement ePim=driver.findElement(By.xpath("//b[text()='PIM']"));
        WebElement eEmpList=driver.findElement(By.id("menu_pim_viewEmployeeList"));

        Actions action=new Actions(driver);

        action.moveToElement(ePim).moveToElement(eEmpList).click().build().perform();

        List<WebElement> emprow=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));

        int rowcount=emprow.size();

        System.out.println("First Name | Last name   |   Job Title |  Supervisor ");

        for(int i=1;i<=rowcount;i++) {

            String firstname = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[3]")).getText();
            String Lastname = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[4]")).getText();
            String jobtitle = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[5]")).getText();
            String supervisor = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[8]")).getText();

            System.out.println(firstname+"    |  "+Lastname+"    |  "+jobtitle+"    |  "+supervisor);

        }

    }


    @AfterMethod
    public void tearDown(){

        driver.close();
    }
}
