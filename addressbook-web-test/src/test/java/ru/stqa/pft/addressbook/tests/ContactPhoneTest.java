package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions (){
        app.goTo().contactPage();///?

        if (app.contact().all().size() ==0) {
            app.contact().creation(new ContactData().withFirstname( "test1" )
                    .withLastname( "test3" ).withAddress( "test5" ).withHomePhone("test6")
                    .withEmail( "test7" ).withGroup( "test1" ),false);
        }
    }

    @Test
    public void testContactsPhone (){
        app.goTo().contactPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(),contact.getMobilePhone(),contact.getWorkPhone())
                .stream().filter((s) -> !s.equals("")).map(ContactPhoneTest::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned (String phone){
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
    }
}