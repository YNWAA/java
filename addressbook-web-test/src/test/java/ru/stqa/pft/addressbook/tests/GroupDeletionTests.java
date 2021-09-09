package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

    @org.testng.annotations.BeforeMethod
    public void ensurePreconditions() {
        app.goTo().GroupPage();
        if (app.db().groupsRequestDB().size() == 0) {
            app.goTo().GroupPage();
            app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
        }
    }

    @Test
    public void testGroupDeletion() {
        Groups before = app.db().groupsRequestDB();
        GroupData deleteGroup = before.iterator().next();
        app.group().deleted(deleteGroup);
        assertThat(app.group().count(), equalTo(before.size()-1));
        Groups after = app.db().groupsRequestDB();
        assertThat(after, org.hamcrest.CoreMatchers.equalTo(before.withOut(deleteGroup)));
        verifyGroupListInUI();
    }

}
