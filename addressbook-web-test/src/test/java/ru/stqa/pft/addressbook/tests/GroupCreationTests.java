package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {
    @org.testng.annotations.DataProvider
    public java.util.Iterator<Object[]> validGroupsFromXML() throws java.io.IOException {
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(new java.io.File("src/test/resources/groups.xml.")))) {
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
            com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream();
            xstream.processAnnotations(GroupData.class);
            @SuppressWarnings("unchecked") java.util.List<ru.stqa.pft.addressbook.model.GroupData> groups = (java.util.List<ru.stqa.pft.addressbook.model.GroupData>) xstream.fromXML(xml);
            return groups.stream().map((g) -> new Object[]{g}).collect( java.util.stream.Collectors.toList()).iterator();
        }
    }

    @org.testng.annotations.DataProvider
    public java.util.Iterator<Object[]> validGroupsFromJson() throws java.io.IOException {
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(new java.io.File("src/test/resources/groups.json.")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            com.google.gson.Gson gson = new com.google.gson.Gson();
            java.util.List<ru.stqa.pft.addressbook.model.GroupData> groups =  gson.fromJson(json, new TypeToken<java.util.List<ru.stqa.pft.addressbook.model.GroupData>>(){}.getType());
            return groups.stream().map((g) -> new Object[]{g}).collect( java.util.stream.Collectors.toList()).iterator();
        }
    }

    @Test(dataProvider = "validGroupsFromJson")
    public void testGroupCreation(GroupData group) {
        app.goTo().GroupPage();
        Groups before = app.group().all();
        app.group().creation( group );
        Groups after = app.group().all();
        assertThat( app.group().count(), equalTo( before.size() + 1 ) );
        assertThat( after, equalTo(
                before.withAdded( group.withId( after.stream().mapToInt( (g) -> g.getId() ).max().getAsInt() ) ) ) );
    }
    @Test(enabled = false)
    public void testBadGroupCreation()  {
        app.goTo().GroupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test2'");
        app.group().create(group);
        assertThat(app.group().count(),equalTo(before.size()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before));
    }

}
