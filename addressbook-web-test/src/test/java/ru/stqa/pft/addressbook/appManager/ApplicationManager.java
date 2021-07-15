package ru.stqa.pft.addressbook.appManager;

public class ApplicationManager {
    public org.openqa.selenium.WebDriver wd;

    public void init() {
        wd = new org.openqa.selenium.firefox.FirefoxDriver();
        wd.manage().timeouts().implicitlyWait( 30, java.util.concurrent.TimeUnit.SECONDS );
        wd.get( "http://localhost/addressbook/group.php" );
        login( "admin", "secret" );
    }

    private void login(String username, String password) {
        wd.findElement( org.openqa.selenium.By.name( "user" ) ).click();
        wd.findElement( org.openqa.selenium.By.name( "user" ) ).clear();
        wd.findElement( org.openqa.selenium.By.name( "user" ) ).sendKeys( username );
        wd.findElement( org.openqa.selenium.By.name( "pass" ) ).click();
        wd.findElement( org.openqa.selenium.By.name( "pass" ) ).clear();
        wd.findElement( org.openqa.selenium.By.name( "pass" ) ).sendKeys( password );
        wd.findElement( org.openqa.selenium.By.xpath( "//input[@value='Login']" ) ).click();
    }

    public void logout() {
        wd.findElement( org.openqa.selenium.By.linkText( "Logout" ) ).click();
    }

    public void submitGroupCreation() {
        wd.findElement( org.openqa.selenium.By.name( "submit" ) ).click();
    }

    public void fillGroupForm(ru.stqa.pft.addressbook.model.GroupData groupData) {
        wd.findElement( org.openqa.selenium.By.name( "group_name" ) ).click();
        wd.findElement( org.openqa.selenium.By.name( "group_name" ) ).clear();
        wd.findElement( org.openqa.selenium.By.name( "group_name" ) ).sendKeys( groupData.getName() );
        wd.findElement( org.openqa.selenium.By.name( "group_header" ) ).click();
        wd.findElement( org.openqa.selenium.By.name( "group_header" ) ).clear();
        wd.findElement( org.openqa.selenium.By.name( "group_header" ) ).sendKeys( groupData.getHeader() );
        wd.findElement( org.openqa.selenium.By.name( "group_footer" ) ).clear();
        wd.findElement( org.openqa.selenium.By.name( "group_footer" ) ).sendKeys( groupData.getFooter() );
    }

    public void initGroupCreation() {
        wd.findElement( org.openqa.selenium.By.linkText( "groups" ) ).click();
        wd.findElement( org.openqa.selenium.By.name( "new" ) ).click();
    }

    public void goToGroupPage() {
        wd.findElement( org.openqa.selenium.By.xpath( "//form[@action='/addressbook/group.php']" ) ).click();
    }

    public void stop() {
        wd.quit();
    }

    private boolean isElementPresent(org.openqa.selenium.By by) {
        try {
            wd.findElement( by );
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
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

    public void deleteSelectGroup() {
      wd.findElement( org.openqa.selenium.By.name("delete")).click();
    }

    public void selectGroup() {
      wd.findElement( org.openqa.selenium.By.name("selected[]")).click();
    }

    public void fillform(ru.stqa.pft.addressbook.model.ContactData contactData) {
      wd.findElement( org.openqa.selenium.By.name("firstname")).clear();
      wd.findElement( org.openqa.selenium.By.name("firstname")).sendKeys( contactData.getFisrtname() );
      wd.findElement( org.openqa.selenium.By.name("middlename")).clear();
      wd.findElement( org.openqa.selenium.By.name("middlename")).sendKeys( contactData.getMiddlename() );
      wd.findElement( org.openqa.selenium.By.name("lastname")).clear();
      wd.findElement( org.openqa.selenium.By.name("lastname")).sendKeys( contactData.getLastname() );
      wd.findElement( org.openqa.selenium.By.name("nickname")).clear();
      wd.findElement( org.openqa.selenium.By.name("nickname")).sendKeys( contactData.getNickname() );
      wd.findElement( org.openqa.selenium.By.name("address")).clear();
      wd.findElement( org.openqa.selenium.By.name("address")).sendKeys( contactData.getAddress() );
      wd.findElement( org.openqa.selenium.By.name("home")).clear();
      wd.findElement( org.openqa.selenium.By.name("home")).sendKeys( contactData.getHome() );
      wd.findElement( org.openqa.selenium.By.name("email")).clear();
      wd.findElement( org.openqa.selenium.By.name("email")).sendKeys( contactData.getEmail() );
    }

    public void submitContactCreation() {
      wd.findElement( org.openqa.selenium.By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void goToContactPage() {
      wd.findElement( org.openqa.selenium.By.linkText("add new")).click();
    }

    public void returnToGroupPage() {
        wd.findElement( org.openqa.selenium.By.linkText( "group page" ) ).click();
    }
}
