package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
    FirefoxDriver wd;
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

    public GroupContactHelper getGroupHelper() {
        return groupContactHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
