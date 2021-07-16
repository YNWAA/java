package ru.stqa.pft.addressbook.appManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class NavigationHelper {
    private WebDriver wd;

    public NavigationHelper(WebDriver wd) {
        this.wd=wd;
    }

    public void goToGroupPage() {
        wd.findElement( By.xpath( "//form[@action='/addressbook/group.php']" ) ).click();
    }

    public void goToContactPage() {
      wd.findElement( By.linkText("add new")).click();
    }
}
