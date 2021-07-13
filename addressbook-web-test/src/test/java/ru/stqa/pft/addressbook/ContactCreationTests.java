package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactCreationTests {
  private WebDriver dr;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    dr = new FirefoxDriver();
    dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    dr.get( "http://localhost/addressbook/index.php" );
  }

  @Test
  public void ContactCreationTests() throws Exception {
    dr.findElement(By.name("user")).click();
    dr.findElement(By.name("user")).clear();
    dr.findElement(By.name("user")).sendKeys("admin");
    dr.findElement(By.name("pass")).click();
    dr.findElement(By.name("pass")).clear();
    dr.findElement(By.name("pass")).sendKeys("secret");
    dr.findElement(By.xpath("//input[@value='Login']")).click();
    GoToContactPage();
    VvodFirstname();
    VvodMiddlename();
    VvodLastname();
    VvodNickname();
    Vvodaddress();
    Vvodhome();
    VvodEmail();
    SubmitContactCreation();
  }

  private void SubmitContactCreation() {
    dr.findElement( org.openqa.selenium.By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void VvodEmail() {
    dr.findElement( org.openqa.selenium.By.name("email")).clear();
    dr.findElement( org.openqa.selenium.By.name("email")).sendKeys("test7");
  }

  private void Vvodhome() {
    dr.findElement( org.openqa.selenium.By.name("home")).clear();
    dr.findElement( org.openqa.selenium.By.name("home")).sendKeys("test6");
  }

  private void Vvodaddress() {
    dr.findElement( org.openqa.selenium.By.name("address")).clear();
    dr.findElement( org.openqa.selenium.By.name("address")).sendKeys("test5");
  }

  private void VvodNickname() {
    dr.findElement( org.openqa.selenium.By.name("nickname")).clear();
    dr.findElement( org.openqa.selenium.By.name("nickname")).sendKeys("test4");
  }

  private void VvodLastname() {
    dr.findElement( org.openqa.selenium.By.name("lastname")).clear();
    dr.findElement( org.openqa.selenium.By.name("lastname")).sendKeys("test3");
  }

  private void VvodMiddlename() {
    dr.findElement( org.openqa.selenium.By.name("middlename")).clear();
    dr.findElement( org.openqa.selenium.By.name("middlename")).sendKeys("test2");
  }

  private void VvodFirstname() {
    dr.findElement( org.openqa.selenium.By.name("firstname")).clear();
    dr.findElement( org.openqa.selenium.By.name("firstname")).sendKeys("test1");
  }

  private void GoToContactPage() {
    dr.findElement( org.openqa.selenium.By.linkText("add new")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    dr.quit();
    }


  private boolean isElementPresent(By by) {
    try {
      dr.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      dr.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

}
