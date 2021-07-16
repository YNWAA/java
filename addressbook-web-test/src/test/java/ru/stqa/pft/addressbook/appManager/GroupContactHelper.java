package ru.stqa.pft.addressbook.appManager;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.ContactData;
public class GroupContactHelper extends HelperBase {

    public GroupContactHelper(FirefoxDriver wd) {
        super( wd );
    }

    public void submitGroupCreation() {
        click( By.name( "submit" ) );
    }

    public void fillGroupForm(GroupData groupData) {
        type( By.name( "group_name" ), groupData.getName() );
        type( By.name( "group_header" ), groupData.getHeader() );
        type( By.name( "group_footer" ), groupData.getFooter() );
    }

    public void initGroupCreation() {
        click( org.openqa.selenium.By.linkText( "groups" ) );
        click( org.openqa.selenium.By.name( "new" ) );
    }

    public void deleteSelectGroup() {
        click( org.openqa.selenium.By.name("delete") );
    }

    public void selectGroup() {
        click( org.openqa.selenium.By.name("selected[]") );
    }

    public void fillform(ContactData contactData) {
        type( By.name( "firstname" ), contactData.getFisrtname() );
        type( By.name( "middlename" ), contactData.getMiddlename() );
        type( By.name( "lastname" ), contactData.getLastname() );
        type( By.name( "nickname" ), contactData.getNickname() );
        type( By.name( "address" ), contactData.getAddress() );
        type( By.name( "home" ), contactData.getHome() );
        type( By.name( "email" ), contactData.getEmail() );
    }

    public void submitContactCreation() {
        click( org.openqa.selenium.By.xpath("//div[@id='content']/form/input[21]") );
    }

    public void returnToGroupPage() {
        click( org.openqa.selenium.By.linkText( "group page" ) );
    }

    public void initGroupModification() {
        click( By.name("edit") );
    }

    public void submitGroupModification() {
        click( By.name("update"));
    }

    public void selectContact() {
        click( By.name("selected[]") );
    }

    public void initContactModification() {
        click( By.name("//img[@alt='Edit']") );
    }

    public void deleteContact() {
        click( By.xpath("//input[@value='Delete']") );
    }

    public void submitDeleteContact() {
        wd.switchTo().alert().accept();
    }
}
