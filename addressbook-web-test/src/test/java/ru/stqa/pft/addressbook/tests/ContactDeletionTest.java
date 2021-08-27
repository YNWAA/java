package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion(){
        app.getContactHelper().goToContactPage();
        if(! app.getContactHelper().isThereAGroup()){
            app.getContactHelper().createContact(( new ContactData( "test1", "test2", "test3", "test4", "test5", "test6", "test7" ,"test1")));
        }
        java.util.List<ru.stqa.pft.addressbook.model.ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteContact();
        app.getContactHelper().submitDeleteContact();
        app.getContactHelper().goToContactPage();
        java.util.List<ru.stqa.pft.addressbook.model.ContactData> after = app.getContactHelper().getContactList();
        org.testng.Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        org.testng.Assert.assertEquals(before, after);
    }
}