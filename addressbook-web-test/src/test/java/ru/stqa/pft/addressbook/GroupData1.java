package ru.stqa.pft.addressbook;

public class GroupData1 {
    private final String fisrtname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String address;
    private final String home;
    private final String email;

    public GroupData1(String fisrtname, String middlename, String lastname, String nickname, String address, String home, String email) {
        this.fisrtname = fisrtname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.address = address;
        this.home = home;
        this.email = email;
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
}
