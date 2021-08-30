package ru.stqa.pft.addressbook.model;
import java.util.Objects;
import java.io.File;
public class ContactData {
    @com.google.gson.annotations.Expose
    private String firstname;
    @com.google.gson.annotations.Expose
    private String lastname;
    @com.google.gson.annotations.Expose
    private String middleName;
    private String group;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    @com.google.gson.annotations.Expose
    private String address;
    private String email;
    private String allPhones;
    @com.thoughtworks.xstream.annotations.XStreamOmitField
    private int id = Integer.MAX_VALUE;

    public File getPhoto() {
        return new File(photo);
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }
    @com.google.gson.annotations.Expose
    private String photo;

    @Override
    public String toString() {
        return "ContactData{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastname;
    }


    public String getGroup() {
        return group;
    }


    public String getFirstname() {
        return firstname;
    }


    public int getId(int id) {
        return id;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getAllPhones() {
        return allPhones;
    }
    public String getAddress() {
        return address;
    }
    public String getHome() {
        return homePhone;
    }

    public String getEmail() {
        return email;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }
    public String getMiddleName() {
        return middleName;
    }

    public ContactData withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }
    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }


    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }
    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }



    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }
    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }



    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id && Objects.equals(lastname, that.lastname) && Objects.equals(firstname, that.firstname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastname, firstname, id);
    }



}