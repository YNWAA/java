package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ContactCreationTests {
  private WebDriver wd;

  @org.testng.annotations.BeforeMethod(alwaysRun = true)
  public void setUp() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, java.util.concurrent.TimeUnit.SECONDS);
    wd.get( "http://localhost/addressbook/index.php" );
    login( "admin","secret" );
  }
  public void login(String username, String password) {
    wd.findElement( org.openqa.selenium.By.name( "user" ) ).click();
    wd.findElement( org.openqa.selenium.By.name( "user" ) ).clear();
    wd.findElement( org.openqa.selenium.By.name( "user" ) ).sendKeys( username );
    wd.findElement( org.openqa.selenium.By.name( "pass" ) ).click();
    wd.findElement( org.openqa.selenium.By.name( "pass" ) ).clear();
    wd.findElement( org.openqa.selenium.By.name( "pass" ) ).sendKeys( password );
    wd.findElement( org.openqa.selenium.By.xpath( "//input[@value='Login']" ) ).click();
  }
  @Test
  public void testContactCreation() {
    goToContactPage();
    fillform( new ContactData( "test1", "test2", "test3", "test4", "test5", "test6", "test7" ) );
    submitContactCreation();
  }

  private void fillform(ru.stqa.pft.addressbook.ContactData contactData) {
    wd.findElement( org.openqa.selenium.By.name("firstname")).clear();
    wd.findElement( org.openqa.selenium.By.name("firstname")).sendKeys( contactData.getFisrtname() );
    wd.findElement( org.openqa.selenium.By.name("middlename")).clear();
    wd.findElement( org.openqa.selenium.By.name("middlename")).sendKeys( contactData.getMiddlename() );
    wd.findElement( org.openqa.selenium.By.name("lastname")).clear();
    wd.findElement( org.openqa.selenium.By.name("lastname")).sendKeys( contactData.getLastname() );
    wd.findElement( org.openqa.selenium.By.name("nickname")).clear();
    wd.findElement( org.openqa.selenium.By.name("nickname")).sendKeys( contactData.getNickname() );
    wd.findElement( org.openqa.selenium.By.name("address")).clear();
    wd.findElement( org.openqa.selenium.By.name("address")).sendKeys( contactData.getAddress() );
    wd.findElement( org.openqa.selenium.By.name("home")).clear();
    wd.findElement( org.openqa.selenium.By.name("home")).sendKeys( contactData.getHome() );
    wd.findElement( org.openqa.selenium.By.name("email")).clear();
    wd.findElement( org.openqa.selenium.By.name("email")).sendKeys( contactData.getEmail() );
  }

  private void submitContactCreation() {
    wd.findElement( org.openqa.selenium.By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void goToContactPage() {
    wd.findElement( org.openqa.selenium.By.linkText("add new")).click();
  }

  @org.testng.annotations.AfterMethod(alwaysRun = true)
  public void tearDown() {
    wd.quit();
    }


  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

}
