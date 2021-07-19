package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().goToContactPage();
        app.getGroupHelper().selectContactModification();
        app.getGroupHelper().fillform( new ContactData( "test1", "test2", "test3", "test4", "test5", "test6", "test7" ) );
        app.getGroupHelper().updateContactModification();
        app.getNavigationHelper().goToContactPage();
    }

}