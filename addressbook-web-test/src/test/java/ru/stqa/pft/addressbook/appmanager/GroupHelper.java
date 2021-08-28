package ru.stqa.pft.addressbook.appmanager;
import org.openqa.selenium.By;
import ru.stqa.pft.addressbook.model.GroupData;
import java.util.ArrayList;;
import java.util.List;
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

    public void selectGroup(int index) {
        wd.findElements( By.name("selected[]") ).get( index ).click();
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

    public void create(ru.stqa.pft.addressbook.model.GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
    }
    public void modify(int index, ru.stqa.pft.addressbook.model.GroupData group) {
        selectGroup( index );
        initGroupModification();
        fillGroupForm( group );
        submitGroupModification();
        returnToGroupPage();
    }
    public void creation(ru.stqa.pft.addressbook.model.GroupData group) {
        initGroupCreation();
        fillGroupForm( group );
        submitGroupCreation();
        returnToGroupPage();
    }
    public void delete(int index) {
        selectGroup( index );
        deleteSelectGroup();
        returnToGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent( By.name("selected[]") );
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")  ).size();
    }

    public List<GroupData> list() {
        List<GroupData> groups=new ArrayList<GroupData>();
        List<org.openqa.selenium.WebElement> elements=wd.findElements( By.cssSelector( "span.group" ) );
        for(org.openqa.selenium.WebElement element :elements){
            String name= element.getText();
            int id=Integer.parseInt( element.findElement( By.tagName( "input" ) ).getAttribute( "value" ));
            groups.add( new GroupData().withId( id ).withName( name ));
        }
        return groups;
    }
}
