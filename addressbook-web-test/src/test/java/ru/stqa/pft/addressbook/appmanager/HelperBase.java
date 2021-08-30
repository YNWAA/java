package ru.stqa.pft.addressbook.appmanager;

public class HelperBase {
    protected org.openqa.selenium.WebDriver wd;

    public HelperBase(org.openqa.selenium.WebDriver wd) {
        this.wd=wd;
    }

    protected void click(org.openqa.selenium.By locator) {
        wd.findElement( locator ).click();
    }

    protected void type(org.openqa.selenium.By locator, String text) {
        click( locator );
        if (text != null) {
            String existingText = wd.findElement( locator ).getAttribute( "value" );
            if (!text.equals( existingText )) {
                wd.findElement( locator ).clear();
                wd.findElement( locator ).sendKeys( text );
            }
        }
    }
        protected void attach(org.openqa.selenium.By locator, java.io.File file) {
            if(file!=null){
                wd.findElement( locator ).sendKeys( file.getAbsolutePath() );
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

    protected boolean isElementPresent(org.openqa.selenium.By locator) {
       try {
           wd.findElement( locator );
           return true;
       } catch (org.openqa.selenium.NoSuchElementException ex)       {
           return false;
       }
       }
}
