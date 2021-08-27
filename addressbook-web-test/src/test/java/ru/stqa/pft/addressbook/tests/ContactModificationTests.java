package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getContactHelper().goToContactPage();
        if(! app.getContactHelper().isThereAGroup()){
            app.getContactHelper().createContact(( new ContactData( "test1", "test2", "test3", "test4", "test5", "test6", "test7" ,"test1")  ));
        }
        java.util.List<ru.stqa.pft.addressbook.model.ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContactModification(before.size() - 1);
        ContactData contact=new ru.stqa.pft.addressbook.model.ContactData( "test1", "test2", "test3", "test4", "test5", "test6", "test7" ,"test1");

        app.getContactHelper().fillform( contact,false );
        app.getContactHelper().updateContactModification();
        app.getContactHelper().goToContactPage();
        java.util.List<ru.stqa.pft.addressbook.model.ContactData> after = app.getContactHelper().getContactList();
        org.testng.Assert.assertEquals(after.size(),before.size());
        before.remove(before.size()-1);
        java.util.Comparator<? super ru.stqa.pft.addressbook.model.ContactData> byId = (java.util.Comparator<ru.stqa.pft.addressbook.model.ContactData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        before.add(contact);
        before.sort(byId);
        after.sort(byId);
        org.testng.Assert.assertEquals(before,after);
        org.testng.Assert.assertEquals(new java.util.HashSet<Object>(before),new java.util.HashSet<Object>(after));
    }

}
