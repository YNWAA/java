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
        if (app.contact().all().size() == 0) {
            app.contact().creation( (new ContactData().withFirstname( "test1" )
                    .withLastname( "test3" ).withAddress( "test5" ).withHomePhone("test6")
                    .withEmail( "test7" ).withGroup( "test1" )),false );
        }
    }

    @Test
    public void testContactDeletion() {
        Contacts before = app.contact().all();
        ContactData deletedContact  = before.iterator().next();
        app.contact().delete(deletedContact);
        assertThat(app.contact().count(),equalTo(before.size() - 1));
        Contacts after = app.contact().all();
        assertThat(after,equalTo(before.withOut(deletedContact)));
    }
}