package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion(){
        app.getContactHelper().goToContactPage();
        if(! app.getContactHelper().isThereAGroup()){
            app.getContactHelper().createContact(( new ru.stqa.pft.addressbook.model.ContactData( "test1", "test2", "test3", "test4", "test5", "test6", "test7" ,"test1")));
        }
        int before=app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().submitDeleteContact();
        app.getContactHelper().goToContactPage();
        int after=app.getContactHelper().getContactCount();
        org.testng.Assert.assertEquals(after,before -1);
    }
}