package ru.stqu.pft.mantis.tests;


import ru.stqu.pft.mantis.appmanager.ApplicationManager;

public class TestBase {

    protected static final ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", org.openqa.selenium.remote.BrowserType.FIREFOX));

    @org.testng.annotations.BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @org.testng.annotations.AfterSuite
    public void tearDown() throws Exception {
        app.stop();
    }
}
