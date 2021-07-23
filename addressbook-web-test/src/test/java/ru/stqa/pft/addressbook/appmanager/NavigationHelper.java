package ru.stqa.pft.addressbook.appmanager;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
public class NavigationHelper extends HelperBase {

    public NavigationHelper(org.openqa.selenium.WebDriver wd) {
        super( wd );
    }

    public void goToGroupPage() {
        if (isElementPresent( org.openqa.selenium.By.tagName( "h1" ) )
                && wd.findElement( org.openqa.selenium.By.tagName( "h1" )).getText().equals( "Groups" )
                && isElementPresent( org.openqa.selenium.By.name( "new" ) ) ){
    return;
        }

    click( org.openqa.selenium.By.xpath("//form[@action='/addressbook/group.php']") );
}

    public void addNewContact() {
      click( By.linkText("add new"));
    }

    public void goToContactPage() {
        if(isElementPresent( By.id( "maintable" ) )){
            return;
        }
       click( By.linkText("home") );
    }
}
