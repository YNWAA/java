package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactGroupCreationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groupsRequestDB().size() == 0) {
            app.goTo().GroupPage();
            app.group().create( new GroupData().withName( "test1" ).withHeader( "test2" ).withFooter( "test3" ) );
            app.goTo().GroupPage();
        }

        if (app.db().contactsRequestDB().size() == 0) {
            Groups groups = app.db().groupsRequestDB();
            java.io.File photo = new java.io.File( "src/test/resources/stru.png" );
            app.contact().page();
            app.contact().creation( new ContactData()
                    .withFirstname("FirstName")
                    .withLastname("LastName")
                    .withAddress( "Address" )
                    .inGroup(groups.iterator().next())
                    .withPhoto(photo),true);

        }
    }
    @Test
    public void addContactInGroupTest() throws Exception {
        Contacts contactsAll = app.db().contactsRequestDB();
        Groups groupsAll = app.db().groupsRequestDB();
        java.util.Collection<ru.stqa.pft.addressbook.model.GroupData> list1 = new java.util.ArrayList<>(groupsAll);
        int id = contactsAll.iterator().next().getId();
        Groups Groupsincontact = app.db().contactInGroup(id);
        java.util.Collection<ru.stqa.pft.addressbook.model.GroupData> list2= new java.util.ArrayList<>(Groupsincontact);
        list1.removeAll(list2);
        GroupData notgroup = list1.iterator().next();
        app.contact().page();
        app.contact().selectContactByIdByName(id, notgroup.getName());
        Groups contactGroupsAfter = app.db().contactInGroup(id);
        assertThat((contactGroupsAfter), org.hamcrest.CoreMatchers.equalTo(Groupsincontact.withAdded(notgroup)));
    }
}
