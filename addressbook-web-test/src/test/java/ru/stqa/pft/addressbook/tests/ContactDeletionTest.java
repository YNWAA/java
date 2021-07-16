package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion(){
        app.getNavigationHelper().goToContactPage();
        app.getGroupHelper().selectContact();
        app.getGroupHelper().deleteContact();
        app.getGroupHelper().submitDeleteContact();
        app.getNavigationHelper().goToContactPage();
    }
}