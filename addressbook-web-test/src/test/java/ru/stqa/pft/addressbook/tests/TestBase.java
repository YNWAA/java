package ru.stqa.pft.addressbook.tests;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
public class TestBase {

    protected ApplicationManager app = new ApplicationManager( org.openqa.selenium.remote.BrowserType.FIREFOX );

    @org.testng.annotations.BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }

    @org.testng.annotations.AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

}
