package ru.stqa.pft.addressbook.appManager;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
public class NavigationHelper extends HelperBase {

    public NavigationHelper(FirefoxDriver wd) {
        super( wd );
    }

    public void goToGroupPage() {
        click( By.xpath( "//form[@action='/addressbook/group.php']" ) );
    }

    public void goToContactPage() {
      click( By.linkText("add new"));
    }
}
