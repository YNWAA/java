package ru.stqa.pft.addressbook.appmanager;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;
public class GroupHelper extends HelperBase {

    public GroupHelper(org.openqa.selenium.WebDriver wd) {
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

    public void createGroup(ru.stqa.pft.addressbook.model.GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent( By.name("selected[]") );
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")  ).size();
    }
}
