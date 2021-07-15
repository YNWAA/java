package ru.stqa.pft.addressbook.tests;

public class TestBase {

    protected final ru.stqa.pft.addressbook.appManager.ApplicationManager app = new ru.stqa.pft.addressbook.appManager.ApplicationManager();

    @org.testng.annotations.BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }

    @org.testng.annotations.AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

}
