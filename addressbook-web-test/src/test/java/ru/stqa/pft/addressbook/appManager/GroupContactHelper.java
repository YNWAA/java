package ru.stqa.pft.addressbook.appManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;
public class GroupContactHelper {
    private WebDriver wd;

    public GroupContactHelper(WebDriver wd) {
      this.wd=wd;
    }

    public void submitGroupCreation() {
        wd.findElement( By.name( "submit" ) ).click();
    }

    public void fillGroupForm(GroupData groupData) {
        wd.findElement( By.name( "group_name" ) ).click();
        wd.findElement( By.name( "group_name" ) ).clear();
        wd.findElement( By.name( "group_name" ) ).sendKeys( groupData.getName() );
        wd.findElement( By.name( "group_header" ) ).click();
        wd.findElement( By.name( "group_header" ) ).clear();
        wd.findElement( By.name( "group_header" ) ).sendKeys( groupData.getHeader() );
        wd.findElement( By.name( "group_footer" ) ).clear();
        wd.findElement( By.name( "group_footer" ) ).sendKeys( groupData.getFooter() );
    }

    public void initGroupCreation() {
        wd.findElement( By.linkText( "groups" ) ).click();
        wd.findElement( By.name( "new" ) ).click();
    }

    public void deleteSelectGroup() {
      wd.findElement( By.name("delete")).click();
    }

    public void selectGroup() {
      wd.findElement( By.name("selected[]")).click();
    }

    public void fillform(ru.stqa.pft.addressbook.model.ContactData contactData) {
      wd.findElement( By.name("firstname")).clear();
      wd.findElement( By.name("firstname")).sendKeys( contactData.getFisrtname() );
      wd.findElement( By.name("middlename")).clear();
      wd.findElement( By.name("middlename")).sendKeys( contactData.getMiddlename() );
      wd.findElement( By.name("lastname")).clear();
      wd.findElement( By.name("lastname")).sendKeys( contactData.getLastname() );
      wd.findElement( By.name("nickname")).clear();
      wd.findElement( By.name("nickname")).sendKeys( contactData.getNickname() );
      wd.findElement( By.name("address")).clear();
      wd.findElement( By.name("address")).sendKeys( contactData.getAddress() );
      wd.findElement( By.name("home")).clear();
      wd.findElement( By.name("home")).sendKeys( contactData.getHome() );
      wd.findElement( By.name("email")).clear();
      wd.findElement( By.name("email")).sendKeys( contactData.getEmail() );
    }

    public void submitContactCreation() {
      wd.findElement( By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void returnToGroupPage() {
        wd.findElement( By.linkText( "group page" ) ).click();
    }
}
