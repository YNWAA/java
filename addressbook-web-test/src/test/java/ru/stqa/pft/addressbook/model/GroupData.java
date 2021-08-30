package ru.stqa.pft.addressbook.model;
import ru.stqa.pft.addressbook.model.GroupData;

@com.thoughtworks.xstream.annotations.XStreamAlias("group")
public class GroupData {
    @com.thoughtworks.xstream.annotations.XStreamOmitField
    private int id = Integer.MAX_VALUE;
    @com.google.gson.annotations.Expose
    private String name;
    @com.google.gson.annotations.Expose
    private String header;
    @com.google.gson.annotations.Expose
    private String footer;

    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
    public GroupData withName(String name) {
        this.name = name;
        return this;
    }

    public GroupData withHeader(String header) {
        this.header = header;
        return this;
    }

    public GroupData withFooter(String footer) {
        this.footer = footer;
        return this;
    }

    public int getId() {
        return id;
    }

    public GroupData withId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ru.stqa.pft.addressbook.model.GroupData groupData = (ru.stqa.pft.addressbook.model.GroupData) o;
        return id == groupData.id && java.util.Objects.equals( name, groupData.name );
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash( id, name );
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }
}
