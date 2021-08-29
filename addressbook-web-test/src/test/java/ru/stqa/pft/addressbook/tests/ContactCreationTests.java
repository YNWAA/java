package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().contactPage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstname( "test1" )
                .withLastname( "test3" ).withAddress( "test5" ).withHomePhone("test6")
                .withEmail( "test7" ).withGroup( "test1" );
        app.contact().creation(contact,true);
        assertThat(app.contact().count(),equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }
    @Test(enabled = false)
    public void testBadContactCreation() throws Exception {
        app.goTo().contactPage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstname( "test1" )
                .withLastname( "test3" ).withAddress( "test5" ).withHomePhone("test6")
                .withEmail( "test7" ).withGroup( "test1" );
        app.contact().creation(contact,true);
        assertThat(app.contact().count(),equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));
    }

}
