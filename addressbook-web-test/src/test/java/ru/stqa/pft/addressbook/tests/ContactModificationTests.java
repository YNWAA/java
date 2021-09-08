package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {
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
    public void testContactModification() {
        java.io.File photo = new java.io.File("src/test/resources/stru.png");
        Contacts before = app.db().contactsRequestDB();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname( "test1" )
                .withLastname( "test3" ).withPhoto(photo).withAddress( "test5" ).withHomePhone("test6")
                .withEmail( "test7" ).withGroup( "test1" );
        app.goTo().contactPage();
        app.contact().modifyi(contact);
        assertThat(app.contact().count(),equalTo(before.size() ));
        Contacts after = app.db().contactsRequestDB();
        assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));
        verifyContactListInUI();
    }


}
