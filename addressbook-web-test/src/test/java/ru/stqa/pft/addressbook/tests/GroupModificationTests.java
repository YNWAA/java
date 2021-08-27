package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import java.util.List;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.GroupData;
public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification(){
        app.getNavigationHelper().goToGroupPage();
        if(! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(( new GroupData( "test1", null, null ) ));
        }
        List<GroupData> before=app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size()-1);
        app.getGroupHelper().initGroupModification();
        GroupData group = new GroupData( "test1", null, null ) ;
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size());
        before.remove(before.size()-1);
        java.util.Comparator<? super ru.stqa.pft.addressbook.model.GroupData> byId = (java.util.Comparator<ru.stqa.pft.addressbook.model.GroupData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        before.sort(byId);
        after.sort(byId);
        before.add(group);
        Assert.assertEquals(before,after);
    }
}
