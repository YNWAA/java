package ru.stqa.pft.addressbook.tests;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.remote.BrowserType;
public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager( BrowserType.FIREFOX );

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite
    public void tearDown() throws Exception {
        app.stop();
    }

}
