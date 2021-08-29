package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions (){
        app.contact().page();

        if (app.contact().all().size() ==0) {
            app.contact().creation(new ContactData().withFirstname( "test1" )
                    .withLastname( "test3" ).withAddress( "test5" ).withHomePhone("test6")
                    .withEmail( "test7" ).withGroup( "test1" ),false);
        }
    }
    @Test
    public void testContactsPhone () {
        app.goTo().contactPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getEmail(), equalTo(merge(contactInfoFromEditForm)));
    }
    private String merge(ContactData contact) {
        return Arrays.asList(contact.getEmail())
                .stream().filter((s) -> !s.equals("")).map(ContactPhoneTest::cleaned)
                .collect(Collectors.joining("\n"));
    }
    public static String cleaned (String email){
        return email.replaceAll("\\s","").replaceAll("[-()]","");
    }
}