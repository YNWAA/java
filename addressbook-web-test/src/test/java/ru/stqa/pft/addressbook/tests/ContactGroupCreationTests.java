package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.Collection;

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
    //В целом логика поиска подходящей пары такая: надо найти "неполную" группу,
    // то есть такую, количество контактов в которой меньше общего количества контактов
    // . А потом выбрать контакт, который не входит в эту группу: взять полный список
    // контактов и выбросить из него контакты, которые входят в выбранную группу --
    // получим контакты, которые можно в неё добавить. Ну а если "неполных" групп нет,
    // тогда, как я написал выше, надо либо удалить контакт из группы, либо создать новую группу,
    // либо создать новый контакт.
    @Test
    public void addContactInGroupTest() throws Exception {
        Contacts contactsAll = app.db().contactsRequestDB();
        int id = contactsAll.iterator().next().getId();
        Groups groupsAll = app.db().groupsRequestDB();
        Groups Groupsincontact = app.db().contactInGroup(id);
        Collection<GroupData> list1 = new ArrayList<>(groupsAll);
        Collection<GroupData> list2= new ArrayList<>(Groupsincontact);
        list1.removeAll(list2);
        if(list1.size()==0){
            app.goTo().GroupPage();
            app.group().create( new GroupData().withName( "test333" ).withHeader( "test333" ).withFooter( "test331" ) );
            app.goTo().GroupPage();
            list1=new ArrayList<>(app.db().groupsRequestDB());
            list1.removeAll(list2);
        }
        GroupData notgroup = list1.iterator().next();
        app.contact().page();
        app.contact().selectContactByIdByName(id, notgroup.getName());
        Groups contactGroupsAfter = app.db().contactInGroup(id);
        assertThat((contactGroupsAfter), org.hamcrest.CoreMatchers.equalTo(Groupsincontact.withAdded(notgroup)));
    }
}
