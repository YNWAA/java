package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTest extends TestBase {
    @org.testng.annotations.BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactPage();
        if (app.db().contactsRequestDB().size() ==0 ) {
            java.io.File photo = new java.io.File("src/test/resources/stru.png");
            app.contact().creation( (new ContactData().withFirstname( "test1" )
                    .withLastname( "test3" ).withPhoto(photo).withAddress( "test5" )),false );
        }
        app.goTo().contactPage();
    }

    @Test
    public void testContactDeletion() throws InterruptedException {
        Contacts before = app.db().contactsRequestDB();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        assertThat(app.contact().count(), equalTo(before.size()-1));
        Contacts after = app.db().contactsRequestDB();
        assertThat(after, org.hamcrest.CoreMatchers.equalTo(before.withOut(deletedContact)));
        verifyContactListInUI();
    }
}