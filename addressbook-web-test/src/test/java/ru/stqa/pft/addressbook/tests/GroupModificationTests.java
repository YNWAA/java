package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification(){
        app.getNavigationHelper().goToGroupPage();
        if(! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(( new ru.stqa.pft.addressbook.model.GroupData( "test1", null, null ) ));
        }
        int before=app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup(before);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm( new GroupData( "test1", "test2", "test3" ) );
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        int after=app.getGroupHelper().getGroupCount();
        org.testng.Assert.assertEquals(after,before );
    }
}
