package ru.stqa.pft.addressbook.appmanager;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;
public class GroupHelper extends HelperBase {

    public GroupHelper(FirefoxDriver wd) {
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


    public void returnToGroupPage() {
        click( org.openqa.selenium.By.linkText( "group page" ) );
    }

    public void initGroupModification() {
        click( By.name("edit") );
    }

    public void submitGroupModification() {
        click( By.name("update"));
    }

}
