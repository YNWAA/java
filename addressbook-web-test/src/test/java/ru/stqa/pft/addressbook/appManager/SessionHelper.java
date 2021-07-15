package ru.stqa.pft.addressbook.appManager;

public class SessionHelper {
    private org.openqa.selenium.WebDriver wd;

    public SessionHelper(org.openqa.selenium.WebDriver wd) {

        this.wd = wd;
    }

    public void login(String username, String password) {
        wd.findElement( org.openqa.selenium.By.name( "user" ) ).click();
        wd.findElement( org.openqa.selenium.By.name( "user" ) ).clear();
        wd.findElement( org.openqa.selenium.By.name( "user" ) ).sendKeys( username );
        wd.findElement( org.openqa.selenium.By.name( "pass" ) ).click();
        wd.findElement( org.openqa.selenium.By.name( "pass" ) ).clear();
        wd.findElement( org.openqa.selenium.By.name( "pass" ) ).sendKeys( password );
        wd.findElement( org.openqa.selenium.By.xpath( "//input[@value='Login']" ) ).click();
    }
}
