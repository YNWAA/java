package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String fisrtname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String address;
    private final String home;
    private final String email;
    private String group;

    public ContactData(String fisrtname, String middlename, String lastname, String nickname, String address, String home, String email,String group) {
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
}
