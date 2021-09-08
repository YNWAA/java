package ru.stqa.pft.addressbook.model;
import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {
    @Expose
    @Column(name = "firstname")
    private String firstname;
    @Expose
    @Column(name = "lastname")
    private String lastname;
    @Expose
    @Column(name = "middlename")
    private String middlename;
    @Transient
    private String group;
    @Transient
    private String email;
    @Column(name = "home")
    @Type(type = "text")
    private String homePhone;
    @Column(name = "mobile")
    @Type(type = "text")
    private String mobilePhone;
    @Column(name = "work")
    @Type(type = "text")
    private String workPhone;
    @Expose
    @Column(name = "nickname")
    private String nickName;
    @Expose
    @Column(name = "address")
    @Type(type = "text")
    private String address;
    @Column(name = "email")
    @Type(type = "text")
    private String mailFirst;
    @Column(name = "email2")
    @Type(type = "text")
    private String mailSecond;
    @Column(name = "email3")
    @Type(type = "text")
    private String mailThree;
    @Expose
    @Column(name = "photo")
    @Type(type = "text")
    private String photo;
    @Transient
    private String allMail;
    @Transient
    private String allPhones;
    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "address_in_groups",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private java.util.Set<GroupData> groups = new java.util.HashSet<GroupData>();


    public File getPhoto() {
        return new File(photo);
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }


    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastname;
    }
    public ContactData withMailFirst(String mailFirst) {
        this.mailFirst = mailFirst;
        return this;
    }

    public ContactData withMailSecond(String mailSecond) {
        this.mailSecond = mailSecond;
        return this;
    }

    public ContactData withMailThree(String mailThree) {
        this.mailThree = mailThree;
        return this;
    }

    public ContactData withAllMail(String allMail) {
        this.allMail = allMail;
        return this;
    }
    public ContactData withNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }


    public String getGroup() {
        return group;
    }
    public String getAllMail() {
        return allMail;
    }

    public String getMailThree() {
        return mailThree;
    }

    public String getMailSecond() {
        return mailSecond;
    }

    public String getMailFirst() {
        return mailFirst;
    }
    public String getNickName() {
        return nickName;
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
    public String getMiddlename() {
        return middlename;
    }

    public ContactData withMiddlename(String middleName) {
        this.middlename = middleName;
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
    public ContactData inGroup(GroupData group) {
        groups.add(group);
        return this;
    }

    public Groups getGroups() {
        return new Groups(groups);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname)&& Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash( firstname, lastname,address,id);
    }
    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstName='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


}