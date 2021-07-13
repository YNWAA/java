package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ContactCreationTests {
  private WebDriver dr;

  @org.testng.annotations.BeforeMethod(alwaysRun = true)
  public void setUp() {
    dr = new FirefoxDriver();
    dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    dr.get( "http://localhost/addressbook/index.php" );
    login( "admin","secret" );
  }
  public void login(String username, String password) {
    dr.findElement( org.openqa.selenium.By.name( "user" ) ).click();
    dr.findElement( org.openqa.selenium.By.name( "user" ) ).clear();
    dr.findElement( org.openqa.selenium.By.name( "user" ) ).sendKeys( username );
    dr.findElement( org.openqa.selenium.By.name( "pass" ) ).click();
    dr.findElement( org.openqa.selenium.By.name( "pass" ) ).clear();
    dr.findElement( org.openqa.selenium.By.name( "pass" ) ).sendKeys( password );
    dr.findElement( org.openqa.selenium.By.xpath( "//input[@value='Login']" ) ).click();
  }
  @Test
  public void testContactCreation() {
    GoToContactPage();
    fillform( new GroupData1( "test1", "test2", "test3", "test4", "test5", "test6", "test7" ) );
    SubmitContactCreation();
  }

  private void fillform(ru.stqa.pft.addressbook.GroupData1 groupData1) {
    dr.findElement( org.openqa.selenium.By.name("firstname")).clear();
    dr.findElement( org.openqa.selenium.By.name("firstname")).sendKeys( groupData1.getFisrtname() );
    dr.findElement( org.openqa.selenium.By.name("middlename")).clear();
    dr.findElement( org.openqa.selenium.By.name("middlename")).sendKeys( groupData1.getMiddlename() );
    dr.findElement( org.openqa.selenium.By.name("lastname")).clear();
    dr.findElement( org.openqa.selenium.By.name("lastname")).sendKeys( groupData1.getLastname() );
    dr.findElement( org.openqa.selenium.By.name("nickname")).clear();
    dr.findElement( org.openqa.selenium.By.name("nickname")).sendKeys( groupData1.getNickname() );
    dr.findElement( org.openqa.selenium.By.name("address")).clear();
    dr.findElement( org.openqa.selenium.By.name("address")).sendKeys( groupData1.getAddress() );
    dr.findElement( org.openqa.selenium.By.name("home")).clear();
    dr.findElement( org.openqa.selenium.By.name("home")).sendKeys( groupData1.getHome() );
    dr.findElement( org.openqa.selenium.By.name("email")).clear();
    dr.findElement( org.openqa.selenium.By.name("email")).sendKeys( groupData1.getEmail() );
  }

  private void SubmitContactCreation() {
    dr.findElement( org.openqa.selenium.By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void GoToContactPage() {
    dr.findElement( org.openqa.selenium.By.linkText("add new")).click();
  }

  @org.testng.annotations.AfterMethod(alwaysRun = true)
  public void tearDown() {
    dr.quit();
    }


  private boolean isElementPresent(org.openqa.selenium.By by) {
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
    } catch (org.openqa.selenium.NoAlertPresentException e) {
      return false;
    }
  }

}
