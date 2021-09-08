package ru.stqa.pft.addressbook.tests;
import java.io.File;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import com.google.gson.reflect.TypeToken;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {
    @org.testng.annotations.DataProvider
    public java.util.Iterator<Object[]> validContactsFromXML() throws java.io.IOException {
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(new File("src/test/resources/contacts.xml")))) {
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
            com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream();
            xstream.processAnnotations(ContactData.class);
            java.util.List<ru.stqa.pft.addressbook.model.ContactData> contacts = (java.util.List<ru.stqa.pft.addressbook.model.ContactData>) xstream.fromXML(xml);
            return contacts.stream().map((g) -> new Object[]{g}).collect( java.util.stream.Collectors.toList()).iterator();
        }
    }

    @org.testng.annotations.DataProvider
    public java.util.Iterator<Object[]> validContactsFromJson() throws java.io.IOException {
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(new File("src/test/resources/contacts.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            com.google.gson.Gson gson = new com.google.gson.Gson();
            java.util.List<ru.stqa.pft.addressbook.model.ContactData> contacts = gson.fromJson(json, new TypeToken<java.util.List<ru.stqa.pft.addressbook.model.ContactData>>() {
            }.getType());
            return contacts.stream().map((g) -> new Object[]{g}).collect( java.util.stream.Collectors.toList()).iterator();
        }
    }


    @Test(dataProvider = "validContactsFromJson")
    public void testContactCreation(ContactData contact) throws Exception {
        app.goTo().contactPage();
        Contacts before = app.db().contactsRequestDB();
        app.contact().creation(contact,true);
        app.goTo().contactPage();
        assertThat(app.contact().count(),equalTo(before.size() + 1));
        Contacts after = app.db().contactsRequestDB();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt(ContactData::getId).max().getAsInt()))));
        verifyContactListInUI();
    }
    @Test(enabled = false)
    public void pageAddNewBadContact() {
        ru.stqa.pft.addressbook.model.Groups groups = app.db().groupsRequestDB();
        File photo = new File("src/test/resources/stru.png");
        app.goTo().contactPage();
        Contacts before = app.db().contactsRequestDB();
        ContactData contact = new ContactData()
                .withFirstname("FirstName'").withLastname("LastName").withMiddlename("MiddleName").withNickName("Donald")
                .inGroup(groups.iterator().next())
                .withHomePhone("111").withMobilePhone("222").withWorkPhone("333").withPhoto(photo);
        app.contact().creation(contact, true);
        app.goTo().contactPage();
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contactsRequestDB();
        assertThat(after, equalTo(before));
        verifyContactListInUI();
    }

}
