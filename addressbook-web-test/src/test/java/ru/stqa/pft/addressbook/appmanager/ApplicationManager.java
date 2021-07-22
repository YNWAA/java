package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    org.openqa.selenium.WebDriver wd;
    private NavigationHelper navigationHelper;
    private ContactHelper contactHelper;
    private GroupHelper groupHelper;
    private SessionHelper sessionHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals( org.openqa.selenium.remote.BrowserType.FIREFOX )){
            wd = new FirefoxDriver();
        } else if(browser.equals( org.openqa.selenium.remote.BrowserType.CHROME )){
            wd = new org.openqa.selenium.chrome.ChromeDriver();
        } else if (browser.equals( org.openqa.selenium.remote.BrowserType.EDGE )){
            wd = new org.openqa.selenium.ie.InternetExplorerDriver();
        }
        wd.manage().timeouts().implicitlyWait( 30, java.util.concurrent.TimeUnit.SECONDS );
        wd.get( "http://localhost/addressbook/group.php" );
        groupHelper = new GroupHelper( wd );
        navigationHelper = new NavigationHelper( wd );
        sessionHelper = new SessionHelper( wd );
        contactHelper = new ContactHelper( wd );
        sessionHelper.login( "admin", "secret" );
    }


    public void logout() {
        wd.findElement( By.linkText( "Logout" ) ).click();
    }

    public void stop() {
        wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
