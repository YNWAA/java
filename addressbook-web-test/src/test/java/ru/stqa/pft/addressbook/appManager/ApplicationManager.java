package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;

public class ApplicationManager {
    WebDriver wd;
    private NavigationHelper navigationHelper;
    private GroupContactHelper groupContactHelper;
private SessionHelper sessionHelper;
    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait( 30, java.util.concurrent.TimeUnit.SECONDS );
        wd.get( "http://localhost/addressbook/group.php" );
        groupContactHelper = new GroupContactHelper( wd );
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login( "admin", "secret" );
    }


    public void logout() {
        wd.findElement( By.linkText( "Logout" ) ).click();
    }

    public void stop() {
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

    public GroupContactHelper getGroupHelper() {
        return groupContactHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
