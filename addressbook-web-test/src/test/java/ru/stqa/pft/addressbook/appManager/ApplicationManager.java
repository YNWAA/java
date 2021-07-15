package ru.stqa.pft.addressbook.appManager;


public class ApplicationManager {
    org.openqa.selenium.WebDriver wd;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
private SessionHelper sessionHelper;
    public void init() {
        wd = new org.openqa.selenium.firefox.FirefoxDriver();
        wd.manage().timeouts().implicitlyWait( 30, java.util.concurrent.TimeUnit.SECONDS );
        wd.get( "http://localhost/addressbook/group.php" );
        groupHelper = new GroupHelper( wd );
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login( "admin", "secret" );
    }


    public void logout() {
        wd.findElement( org.openqa.selenium.By.linkText( "Logout" ) ).click();
    }

    public void stop() {
        wd.quit();
    }

    private boolean isElementPresent(org.openqa.selenium.By by) {
        try {
            wd.findElement( by );
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (org.openqa.selenium.NoAlertPresentException e) {
            return false;
        }
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
