package ru.stqa.pft.addressbook.model;

public class ContactData {
    private int id=Integer.MAX_VALUE;
    private String fisrtname;
    private String middlename;
    private String lastname;
    private String nickname;
    private String address;
    private String home;
    private String email;
    private String group;

    public ContactData withFisrtname(String fisrtname) {
        this.fisrtname = fisrtname;
        return this;
    }

    public ContactData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHome(String home) {
        this.home = home;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }


    @Override
    public String toString(){
        return "ContactData{"+
                "id='"+id+'\''+
                ", firstname='"+fisrtname+'\''+
                        ", lastname='"+lastname+'\''+
                        '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData contact = (ContactData) o;
        return java.util.Objects.equals(fisrtname, contact.fisrtname) && java.util.Objects.equals(lastname, contact.lastname);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(fisrtname, lastname);
    }

    public String getFisrtname() {
        return fisrtname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getAddress() {
        return address;
    }

    public String getHome() {
        return home;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }
}
