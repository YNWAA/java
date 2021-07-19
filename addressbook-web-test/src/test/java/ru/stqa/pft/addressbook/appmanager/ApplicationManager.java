package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
    FirefoxDriver wd;
    private NavigationHelper navigationHelper;
    private ContactHelper contactHelper;
    private GroupHelper groupHelper;
    private SessionHelper sessionHelper;
    public void init() {
        wd = new FirefoxDriver();
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
