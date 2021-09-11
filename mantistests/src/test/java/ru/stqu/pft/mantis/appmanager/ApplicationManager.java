package ru.stqu.pft.mantis.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import static org.openqa.selenium.remote.BrowserType.*;

public class ApplicationManager {
    org.openqa.selenium.WebDriver wd;
    private final java.util.Properties properties;
    private String browser;


    public ApplicationManager(String browser)  {
        this.browser = browser;
        properties = new java.util.Properties();
        }

    public void init() throws java.io.IOException {
        String target = System.getProperty("target", "local");
        properties.load(new java.io.FileReader(new java.io.File(String.format("src/test/resources/%s.properties", target))));
        if (browser.equals( FIREFOX )){
            wd = new FirefoxDriver();
        } else if(browser.equals( OPERA )){
            wd = new OperaDriver();
        } else if (browser.equals( EDGE )){
            wd = new InternetExplorerDriver();
        }
        wd.manage().timeouts().implicitlyWait( 10, java.util.concurrent.TimeUnit.SECONDS );
        wd.get(properties.getProperty("web.BaseURL"));

    }


    public void stop() {
        wd.quit();
    }

    public HttpSession newSession() {
        return new HttpSession(this);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
    public RegistrationHelper registration() {
        if (registrationHelper == null) {
            registrationHelper = new RegistrationHelper(this);
        }
        return registrationHelper;
    }
}
