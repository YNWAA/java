package ru.stqa.pft.addressbook.tests;
import ru.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> before=app.getGroupHelper().getGroupList();
        app.getGroupHelper().initGroupCreation();
        GroupData group = new GroupData( "test1", null, null ) ;
        app.getGroupHelper().fillGroupForm( group);
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after=app.getGroupHelper().getGroupList();
        org.testng.Assert.assertEquals(after.size(),before.size() +1);
        group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        java.util.Comparator<? super ru.stqa.pft.addressbook.model.GroupData> byId = (java.util.Comparator<ru.stqa.pft.addressbook.model.GroupData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        before.sort(byId);
        after.sort(byId);
        before.add(group);
        org.testng.Assert.assertEquals(new java.util.HashSet<Object>(before),new java.util.HashSet<Object>(after));
    }

}
