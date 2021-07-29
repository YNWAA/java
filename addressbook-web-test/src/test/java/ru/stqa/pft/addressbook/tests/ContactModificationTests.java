package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getContactHelper().goToContactPage();
        if(! app.getContactHelper().isThereAGroup()){
            app.getContactHelper().createContact(( new ru.stqa.pft.addressbook.model.ContactData( "test1", "test2", "test3", "test4", "test5", "test6", "test7" ,"test1")  ));
        }
        int before=app.getContactHelper().getContactCount();
        app.getContactHelper().selectContactModification(before -1);
        app.getContactHelper().fillform( new ContactData( "test1", "test2", "test3", "test4", "test5", "test6", "test7",null ),false );
        app.getContactHelper().updateContactModification();
        app.getContactHelper().goToContactPage();
        int after=app.getContactHelper().getContactCount();
        org.testng.Assert.assertEquals(after,before );
    }

}
