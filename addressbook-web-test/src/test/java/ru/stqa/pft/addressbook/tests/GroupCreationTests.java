package ru.stqa.pft.addressbook.tests;
import ru.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().GroupPage();
        List<GroupData> before=app.group().list();
        GroupData group = new GroupData( ).withName( "test1" ) ;
        app.group().creation( group );
        List<GroupData> after=app.group().list();
        org.testng.Assert.assertEquals(after.size(),before.size() +1);
        before.add(group);
        java.util.Comparator<? super ru.stqa.pft.addressbook.model.GroupData> byId = (java.util.Comparator<ru.stqa.pft.addressbook.model.GroupData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        before.sort(byId);
        after.sort(byId);
        org.testng.Assert.assertEquals(new java.util.HashSet<Object>(before),new java.util.HashSet<Object>(after));
    }



}
