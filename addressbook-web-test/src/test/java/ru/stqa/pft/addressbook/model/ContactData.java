package ru.stqa.pft.addressbook.model;

public class ContactData {
    private int id;
    private final String fisrtname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String address;
    private final String home;
    private final String email;
    private String group;

    @Override
    public String toString(){
        return "ContactData{"+
                "id='"+id+'\''+
                ", firstname='"+fisrtname+'\''+
                        ", lastname='"+lastname+'\''+
                        '}';
    }

    public ContactData(int id, String fisrtname, String middlename, String lastname, String nickname, String address, String home, String email) {
        this.id=id;
        this.fisrtname = fisrtname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.address = address;
        this.home = home;
        this.email = email;
        this.group = group;
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
    public ContactData(String fisrtname, String middlename, String lastname, String nickname, String address, String home, String email, String group) {
        this.id=Integer.MAX_VALUE;
        this.fisrtname = fisrtname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.address = address;
        this.home = home;
        this.email = email;
        this.group = group;
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

    public void setId(int id) {
        this.id = id;
    }
}
