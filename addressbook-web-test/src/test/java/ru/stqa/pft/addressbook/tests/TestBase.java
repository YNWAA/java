package ru.stqa.pft.addressbook.tests;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBase {

    protected static final ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite
    public void tearDown() throws Exception {
        app.stop();
    }
    public void verifyGroupListInUI() {
        if (Boolean.getBoolean("verifyUI")) {
            ru.stqa.pft.addressbook.model.Groups dbGroups = app.db().groupsRequestDB();
            ru.stqa.pft.addressbook.model.Groups uiGroups = app.group().all();
            assertThat(uiGroups, equalTo(dbGroups.stream()
                    .map((g) -> new ru.stqa.pft.addressbook.model.GroupData().withId(g.getId()).withName(g.getName()))
                    .collect( java.util.stream.Collectors.toSet())));
        }
    }

    public void verifyContactListInUI() {
        if (Boolean.getBoolean("verifyUI")) {
            ru.stqa.pft.addressbook.model.Contacts dbContacts = app.db().contactsRequestDB();
            ru.stqa.pft.addressbook.model.Contacts uiContacts = app.contact().all();
            assertThat(uiContacts, equalTo(dbContacts.stream()
                    .map((g) -> new ru.stqa.pft.addressbook.model.ContactData().withId(g.getId()).withFirstname(g.getFirstname()).withLastname(g.getLastName())
                            .withWorkPhone(g.getWorkPhone()).withHomePhone(g.getHomePhone()).withMobilePhone(g.getMobilePhone()))
                    .collect( java.util.stream.Collectors.toSet())));
        }
    }

}
