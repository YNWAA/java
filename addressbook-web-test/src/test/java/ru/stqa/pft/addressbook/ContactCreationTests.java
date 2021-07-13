package ru.stqa.pft.addressbook;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactCreationTests {
  private WebDriver driver;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void ContactCreationTests() throws Exception {
    driver.get("http://localhost/addressbook/index.php");
    driver.findElement(By.name("user")).click();
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys("admin");
    driver.findElement(By.name("pass")).click();
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys("secret");
    driver.findElement(By.xpath("//input[@value='Login']")).click();
    driver.findElement(By.linkText("add new")).click();
    driver.findElement(By.name("firstname")).click();
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys("test1");
    driver.findElement(By.name("middlename")).clear();
    driver.findElement(By.name("middlename")).sendKeys("test2");
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys("test3");
    driver.findElement(By.name("nickname")).clear();
    driver.findElement(By.name("nickname")).sendKeys("test4");
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys("test5");
    driver.findElement(By.name("home")).clear();
    driver.findElement(By.name("home")).sendKeys("test6");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("test7");
    driver.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    driver.findElement(By.linkText("home")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    }


  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

}
