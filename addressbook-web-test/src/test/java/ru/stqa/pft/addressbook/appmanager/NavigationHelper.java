package ru.stqa.pft.addressbook.appmanager;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
public class NavigationHelper extends HelperBase {

    public NavigationHelper(org.openqa.selenium.WebDriver wd) {
        super( wd );
    }

    public void goToGroupPage() {
        click( By.xpath( "//form[@action='/addressbook/group.php']" ) );
    }

    public void addNewContact() {
      click( By.linkText("add new"));
    }

    public void goToContactPage() {
       click( By.linkText("home") );
    }
}
