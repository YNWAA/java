package ru.stqa.pft.addressbook.appmanager;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
public class NavigationHelper extends HelperBase {

    public NavigationHelper(org.openqa.selenium.WebDriver wd) {
        super( wd );
    }
    public void contactPage() {
        if(isElementPresent( By.id( "maintable" ) )){
            return;
        }
        click( By.linkText("home") );
    }

    public void GroupPage() {
        if (isElementPresent( org.openqa.selenium.By.tagName( "h1" ) )
                && wd.findElement( org.openqa.selenium.By.tagName( "h1" )).getText().equals( "Groups" )
                && isElementPresent( org.openqa.selenium.By.name( "new" ) ) ){
    return;
        }

    click( org.openqa.selenium.By.xpath("//a[contains(text(),'groups')]") );
}

    public void addNewContact() {
      click( By.linkText("add new"));
    }


}
