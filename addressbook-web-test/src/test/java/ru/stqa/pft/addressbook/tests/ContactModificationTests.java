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
        app.getContactHelper().fillform( new ContactData( "test1", "test2", "test3", "test4", "test5", "test6", "test7",null ),false );
        app.getContactHelper().updateContactModification();
        app.getContactHelper().goToContactPage();
        java.util.List<ru.stqa.pft.addressbook.model.ContactData> after = app.getContactHelper().getContactList();
        org.testng.Assert.assertEquals(after.size(), before.size());
        before.remove(before.size() - 1);
        org.testng.Assert.assertEquals(new java.util.HashSet<Object>(before), new java.util.HashSet<Object>(after));
    }

}
