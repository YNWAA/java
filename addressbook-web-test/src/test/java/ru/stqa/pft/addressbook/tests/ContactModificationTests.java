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
        if (app.contact().all().size() == 0) {
            app.contact().creation( (new ContactData().withFirstname( "test1" )
                    .withLastname( "test3" ).withAddress( "test5" ).withHomePhone("test6")
                    .withEmail( "test7" ).withGroup( "test1" )),false );
        }
    }
    @Test
    public void testContactModification() {
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname( "test1" )
                .withLastname( "test3" ).withAddress( "test5" ).withHomePhone("test6")
                .withEmail( "test7" ).withGroup( "test1" );
        app.contact().modifyi(contact);
        assertThat(app.contact().count(),equalTo(before.size() ));
        Contacts after = app.contact().all();
        assertThat(after,equalTo(before.withOut(modifiedContact).withAdded(contact)));
    }


}
