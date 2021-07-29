package ru.stqa.pft.addressbook.tests;
import ru.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().goToGroupPage();
        int before=app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm( new GroupData( "test1", null, null ) );
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
        int after=app.getGroupHelper().getGroupCount();
        org.testng.Assert.assertEquals(after,before +1);
        app.logout();
    }

}
