package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ApplicationManager {
    WebDriver wd;
    private NavigationHelper navigationHelper;
    private ContactHelper contactHelper;
    private GroupHelper groupHelper;
    private SessionHelper sessionHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals( BrowserType.FIREFOX )){
            wd = new FirefoxDriver();
        } else if(browser.equals( BrowserType.OPERA )){
            wd = new OperaDriver();
        } else if (browser.equals( BrowserType.EDGE )){
            wd = new InternetExplorerDriver();
        }
        wd.manage().timeouts().implicitlyWait( 10, java.util.concurrent.TimeUnit.SECONDS );
        wd.get( "http://localhost/addressbook" );
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

    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public ContactHelper contact() {
        return contactHelper;
    }
}
