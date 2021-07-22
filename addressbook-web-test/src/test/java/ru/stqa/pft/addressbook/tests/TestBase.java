package ru.stqa.pft.addressbook.tests;

public class TestBase {

    protected ru.stqa.pft.addressbook.appmanager.ApplicationManager app = new ru.stqa.pft.addressbook.appmanager.ApplicationManager( org.openqa.selenium.remote.BrowserType.FIREFOX );

    @org.testng.annotations.BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }

    @org.testng.annotations.AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

}
