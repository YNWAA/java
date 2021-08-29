package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.name;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super( wd );
    }

    public void submitGroupCreation() {
        click( name( "submit" ) );
    }

    public void fillGroupForm(GroupData groupData) {
        type( name( "group_name" ), groupData.getName() );
        type( name( "group_header" ), groupData.getHeader() );
        type( name( "group_footer" ), groupData.getFooter() );
    }

    public void initGroupCreation() {
        click( linkText( "groups" ) );
        click( name( "new" ) );
    }

    public void deleteSelectGroup() {
        click( name( "delete" ) );
    }

    public void selectGroup(int index) {
        wd.findElements( name( "selected[]" ) ).get( index ).click();
    }

    public void selectGroupById(int id) {
        wd.findElement( By.cssSelector( "input[value='" + id + "']" ) ).click();
    }

    public void returnToGroupPage() {
        click( linkText( "group page" ) );
    }

    public void initGroupModification() {
        click( name( "edit" ) );
    }

    public void submitGroupModification() {
        click( name( "update" ) );
    }

    public void create(GroupData group) {
        initGroupCreation();
        fillGroupForm( group );
        submitGroupCreation();
        returnToGroupPage();
    }

    public void modify(GroupData group) {
        selectGroupById( group.getId() );
        initGroupModification();
        fillGroupForm( group );
        submitGroupModification();
        groupCache = null;
        returnToGroupPage();
    }

    public void creation(GroupData group) {
        initGroupCreation();
        fillGroupForm( group );
        submitGroupCreation();
        groupCache = null;
        returnToGroupPage();
    }


    public void deleted(GroupData group) {
        selectGroupById( group.getId() );
        deleteSelectGroup();
        groupCache = null;
        returnToGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent( name( "selected[]" ) );
    }

    public int count() {
        return wd.findElements( name( "selected[]" ) ).size();
    }

    private Groups groupCache = null;

    public Groups all() {
        if (groupCache !=null){
            return new Groups(groupCache);
        }
        groupCache= new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupCache.add(new GroupData().withId(id).withName(name));
        }
        return new Groups(groupCache);
    }
}

