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
            app.contact().create( (new ContactData().withFisrtname( "test1" )
                    .withMiddlename( "test2" ).withLastname( "test3" ).withNickname( "test4" )
                    .withAddress( "test5" ).withHome( "test6" ).withEmail( "test7" ).withGroup( "test1" )) );
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId( modifiedContact.getId() ).withFisrtname( "test1" )
                .withMiddlename( "test2" ).withLastname( "test3" ).withNickname( "test4" )
                .withAddress( "test5" ).withHome( "test6" ).withEmail( "test7" ).withGroup( "test1" );
        app.contact().modifyi( contact );
        Contacts after = app.contact().all();
        Assert.assertEquals( after.size(), before.size() );
        assertThat( after, equalTo( before.withOut( modifiedContact ).withAdded( contact ) ) );
    }


}
