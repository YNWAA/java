package ru.stqa.pft.addressbook.appmanager;

public class HelperBase {
    protected org.openqa.selenium.firefox.FirefoxDriver wd;

    public HelperBase(org.openqa.selenium.firefox.FirefoxDriver wd) {
        this.wd=wd;
    }

    protected void click(org.openqa.selenium.By locator) {
        wd.findElement( locator ).click();
    }

    protected void type(org.openqa.selenium.By locator, String text) {
        click( locator );
        wd.findElement( locator ).clear();
        wd.findElement( locator ).sendKeys( text );
    }
    private boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (org.openqa.selenium.NoAlertPresentException e) {
            return false;
        }
    }
}
