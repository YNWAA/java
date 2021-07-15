package ru.stqa.pft.addressbook.appManager;

public class GroupHelper {
    private org.openqa.selenium.WebDriver wd;

    public GroupHelper(org.openqa.selenium.WebDriver wd) {
      this.wd=wd;
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

    public void returnToGroupPage() {
        wd.findElement( org.openqa.selenium.By.linkText( "group page" ) ).click();
    }
}
