package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GroupCreationTests {
    private WebDriver wd;

    @org.testng.annotations.BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait( 30, TimeUnit.SECONDS );
        wd.get( "http://localhost/addressbook/group.php" );
        login( "admin", "secret" );
    }

    private void login(String username, String password) {
        wd.findElement( org.openqa.selenium.By.name( "user" ) ).click();
        wd.findElement( org.openqa.selenium.By.name( "user" ) ).clear();
        wd.findElement( org.openqa.selenium.By.name( "user" ) ).sendKeys( username );
        wd.findElement( org.openqa.selenium.By.name( "pass" ) ).click();
        wd.findElement( org.openqa.selenium.By.name( "pass" ) ).clear();
        wd.findElement( org.openqa.selenium.By.name( "pass" ) ).sendKeys( password );
        wd.findElement( org.openqa.selenium.By.xpath( "//input[@value='Login']" ) ).click();
    }

    @Test
    public void testGroupCreation() throws Exception {

        goToGroupPage();
        initGroupCreation();
        fillGroupForm( new GroupData( "test1", "test2", "test3" ) );
        submitGroupCreation();
        returnToGroupPage();
        logout();
    }

    private void logout() {
        wd.findElement( org.openqa.selenium.By.linkText( "Logout" ) ).click();
    }

    private void returnToGroupPage() {
        wd.findElement( org.openqa.selenium.By.linkText( "group page" ) ).click();
    }

    private void submitGroupCreation() {
        wd.findElement( org.openqa.selenium.By.name( "submit" ) ).click();
    }

    private void fillGroupForm(ru.stqa.pft.addressbook.GroupData groupData) {
        wd.findElement( org.openqa.selenium.By.name( "group_name" ) ).click();
        wd.findElement( org.openqa.selenium.By.name( "group_name" ) ).clear();
        wd.findElement( org.openqa.selenium.By.name( "group_name" ) ).sendKeys( groupData.getName() );
        wd.findElement( org.openqa.selenium.By.name( "group_header" ) ).click();
        wd.findElement( org.openqa.selenium.By.name( "group_header" ) ).clear();
        wd.findElement( org.openqa.selenium.By.name( "group_header" ) ).sendKeys( groupData.getHeader() );
        wd.findElement( org.openqa.selenium.By.name( "group_footer" ) ).clear();
        wd.findElement( org.openqa.selenium.By.name( "group_footer" ) ).sendKeys( groupData.getFooter() );
    }

    private void initGroupCreation() {
        wd.findElement( org.openqa.selenium.By.linkText( "groups" ) ).click();
        wd.findElement( org.openqa.selenium.By.name( "new" ) ).click();
    }

    private void goToGroupPage() {
        wd.findElement( org.openqa.selenium.By.xpath( "//form[@action='/addressbook/group.php']" ) ).click();
    }

    @org.testng.annotations.AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        wd.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            wd.findElement( by );
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
