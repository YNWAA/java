package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.List;
import org.testng.Assert;
import java.util.Comparator;

public class ContactModificationTests extends TestBase {
    @org.testng.annotations.BeforeMethod
    public void ensurePreconditions(){
        app.contact().list();
        if(! app.contact().isThereAGroup()){
            app.contact().create(( new ContactData( "test1", "test2", "test3", "test4", "test5", "test6", "test7" ,"test1")  ));
        }
    }
    @Test
    public void testContactModification() {
        List<ContactData> before = app.contact().getContactList();
        ContactData contact=new ContactData( "test1", "test2", "test3", "test4", "test5", "test6", "test7" ,"test1");
        int index =before.size()-1;
        app.contact().modifyContact( index, contact );
        List<ContactData> after = app.contact().getContactList();
        Assert.assertEquals(after.size(),before.size());
        before.remove(index);
        Comparator<? super ContactData> byId = (Comparator<ContactData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        before.add(contact);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
        Assert.assertEquals(new java.util.HashSet<Object>(before),new java.util.HashSet<Object>(after));
    }



}
