package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import java.util.List;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.GroupData;
public class GroupModificationTests extends TestBase {

    @org.testng.annotations.BeforeMethod
    public void ensurePreconditions(){
        app.goTo().GroupPage();
        if(app.group().list().size()==0){
            app.group().create(( new GroupData( "test1", null, null ) ));
        }
    }

    @Test
    public void testGroupModification(){
        List<GroupData> before=app.group().list();
        int index =before.size()-1;
        GroupData group = new GroupData(before.get(index).getId(), "test1", null, null );
        app.group().modify( index, group );
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(),before.size());
        before.remove(index);
        before.add(group);
        java.util.Comparator<? super ru.stqa.pft.addressbook.model.GroupData> byId = (java.util.Comparator<ru.stqa.pft.addressbook.model.GroupData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }


}
