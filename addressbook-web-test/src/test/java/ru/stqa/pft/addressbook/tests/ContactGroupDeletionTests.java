package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class ContactGroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws Exception {
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
            app.contact().page();
            Contacts after = app.db().contactsRequestDB();
            ContactData contactgroup = after.iterator().next();
            GroupData groupcontact = groups.iterator().next();
            app.contact().selectContactByIdByName(contactgroup.getId(), groupcontact.getName());
        }
    }


    @Test
    public void deleteContactInGroupTest() {
        ContactData groupData = app.db().contactAllGroups();
        int id = groupData.getId();
        Groups groupBefore = app.db().contactInGroup(id);
        GroupData group = groupBefore.iterator().next();
        String groupName = group.getName();
        app.contact().page();
        app.contact().contactDeleteGroup(id, groupName);
        Groups contactInGroupAfter = app.db().contactInGroup(id);
        assertThat((contactInGroupAfter), org.hamcrest.CoreMatchers.equalTo(groupBefore.withOut(group)));


    }
}
