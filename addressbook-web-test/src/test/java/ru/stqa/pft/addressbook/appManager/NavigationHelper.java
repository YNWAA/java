package ru.stqa.pft.addressbook.appManager;

public class NavigationHelper {
    private org.openqa.selenium.WebDriver wd;

    public NavigationHelper(org.openqa.selenium.WebDriver wd) {
        this.wd=wd;
    }

    public void goToGroupPage() {
        wd.findElement( org.openqa.selenium.By.xpath( "//form[@action='/addressbook/group.php']" ) ).click();
    }

    public void goToContactPage() {
      wd.findElement( org.openqa.selenium.By.linkText("add new")).click();
    }
}
