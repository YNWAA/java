package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super( wd );
    }


    public void fillform(ContactData contactData, boolean creation) {
        type( By.name( "firstname" ), contactData.getFirstname() );

        type( By.name( "middlename" ), contactData.getMiddlename());
        type( By.name( "lastname" ), contactData.getLastName() );
    //    type( By.name( "nickname" ), contactData.getNickname() );
        attach( By.name("photo") ,contactData.getPhoto());
        type( By.name( "address"), contactData.getAddress() );
      //  type( By.name( "home" ), contactData.getHome() );
       // type( By.name( "email" ), contactData.getEmail() );
        if (creation) {
            if (contactData.getGroups().size()>0) {
                org.testng.Assert.assertTrue(contactData.getGroups().size()==1);
                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
            } else {
                org.testng.Assert.assertFalse(isElementPresent(By.name("new_group")));
            }
        }
    }

    public void submitContactCreation() {
        click( By.xpath( "//div[@id='content']/form/input[21]" ) );
    }
    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public void selectContactById(int id) {
        wd.findElement( By.cssSelector( "input[id='" + id + "']" ) ).click();
    }

    public void deleteContact() {
        click( By.xpath( "//input[@value='Delete']" ) );
    }

    public void submitDeleteContact() {
        wd.switchTo().alert().accept();
        wd.findElement( By.cssSelector( "div.msgbox" ) );
    }

    public void selectContactModificationById(int id) {
        wd.findElement( By.cssSelector( String.format( "a[href='edit.php?id=%s']", id ) ) ).click();

    }

    public void updateContactModification() {
        click( org.openqa.selenium.By.name( "update" ) );

    }

    public boolean isThereAGroup() {
        return isElementPresent( By.name( "selected[]" ) );
    }

    public void addNewContact() {
        click(By.linkText("add new"));
    }

    public void page() {
        if (isElementPresent( By.id( "maintable" ) )) {
            return;
        }
        click( By.linkText( "home" ) );
    }

    public void modifyi(ContactData contact) {
        selectContactModificationById( contact.getId() );
        fillform( contact, false );
        updateContactModification();
        contactCache = null;
        page();
    }
    public void verifyGroupContact(){
        String text = "[none]";
        selectTypeGroupsInContacts(text);
        selectAllContact();
        clickAddGroup();
    }
    public void clickAddGroup() {
        click(By.xpath("//input[@value='Add to']"));
    }
    private void selectAllContact() {
        click(By.id("MassCB"));
    }

    public boolean verifyFreeContact() {
        String text = "[none]";
        selectTypeGroupsInContacts(text);
        String number = wd.findElements(By.id("search_count")).get(0).getText();
        return number.equals("0");
    }
    public void selectTypeGroupsInContacts(String text) {
        click(By.name("group"));
        new Select(wd.findElement(By.name("group"))).selectByVisibleText(text);
    }
    public void delete(ContactData contact) {
        selectContactById( contact.getId() );
        deleteContact();
        submitDeleteContact();
        contactCache = null;
        page();
    }
    public void deleteGroupIsContact() {
        click(By.name("remove"));
    }
    public void contactDeleteGroup(ContactData contact, String text) {
        selectTypeGroupsInContacts(text);
        selectContactById(contact.getId());
        deleteGroupIsContact();
        page();
    }

    public void creation(ContactData contact, boolean b) {
        addNewContact();
        fillform( contact, b );
        submitContactCreation();
        contactCache = null;
        page();
    }
    public void addGroupInContactById(ContactData contact){
        selectContactById(contact.getId());
        clickAddGroup();
        page();
    }
    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null){
            return new Contacts(contactCache);
        }
        contactCache= new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String firstname = cells.get(2).getText();
            String lastname = cells.get(1).getText();
            String allPhones = cells.get(5).getText();
            String address = cells.get(3).getText();
            String email = cells.get(4).getText();
            contactCache.add(new ContactData().withId(id).withLastname(lastname).withFirstname(firstname)
                    .withAddress(address).withEmail(email)
                    .withAllPhones(allPhones).withGroup("test2"));
        }
        return new Contacts(contactCache);
    }
    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationFromId(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().
                withId(contact.getId()).withFirstname(firstname).withLastname(lastname).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withAddress(address).withEmail(email);
    }
    private void initContactModificationFromId(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']",id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
    }
}