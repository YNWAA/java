package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().goToContactPage();
        app.getContactHelper().selectContactModification();
        app.getContactHelper().fillform( new ContactData( "test1", "test2", "test3", "test4", "test5", "test6", "test7",null ),false );
        app.getContactHelper().updateContactModification();
        app.getNavigationHelper().goToContactPage();
    }

}
