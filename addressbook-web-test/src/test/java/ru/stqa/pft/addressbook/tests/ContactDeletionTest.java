package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.List;
import org.testng.Assert;

public class ContactDeletionTest extends TestBase {
    public void ensurePreconditions(){
        app.contact().list();
        if(! app.contact().isThereAGroup()){
            app.contact().create(( new ContactData( "test1", "test2", "test3", "test4", "test5", "test6", "test7" ,"test1")));
        }
    }
    @Test
    public void testContactDeletion(){
        List<ContactData> before = app.contact().getContactList();
        int index =before.size()-1;
        app.contact().modifyDeletionContact( index );
        List<ContactData> after = app.contact().getContactList();
        Assert.assertEquals(after.size(), index);
        before.remove(index);
        Assert.assertEquals(before, after);
    }


}