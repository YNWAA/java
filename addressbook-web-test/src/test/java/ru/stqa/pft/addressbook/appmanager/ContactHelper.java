package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.openqa.selenium.By.tagName;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super( wd );
    }


    public void fillform(ContactData contactData, boolean creation) {
        type( By.name( "firstname" ), contactData.getFisrtname() );
        type( By.name( "middlename" ), contactData.getMiddlename() );
        type( By.name( "lastname" ), contactData.getLastname() );
        type( By.name( "nickname" ), contactData.getNickname() );
        type( By.name( "address" ), contactData.getAddress() );
        type( By.name( "home" ), contactData.getHome() );
        type( By.name( "email" ), contactData.getEmail() );
        if (creation) {
            if (!wd.findElement( tagName( "option" ) ).getText().equals( contactData.getGroup() )) {
                new Select( wd.findElement( By.name( "new_group" ) ) ).selectByVisibleText( "[none]" );
            } else {
                new Select( wd.findElement( By.name( "new_group" ) ) ).selectByVisibleText( contactData.getGroup() );
            }
        } else {
            org.testng.Assert.assertFalse( isElementPresent( By.name( "new_group" ) ) );
        }
    }

    public void submitContactCreation() {
        click( By.xpath( "//div[@id='content']/form/input[21]" ) );
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
        click( By.linkText( "add new" ) );
    }

    public void page() {
        if (isElementPresent( By.id( "maintable" ) )) {
            return;
        }
        click( By.linkText( "home" ) );
    }

    public void create(ContactData contact) {
        addNewContact();
        fillform( contact, true );
        submitContactCreation();
        page();
    }

    public void modifyi(ContactData contact) {
        selectContactModificationById( contact.getId() );
        fillform( contact, false );
        updateContactModification();
        page();
    }

    public void delete(ContactData contact) {
        selectContactById( contact.getId() );
        deleteContact();
        submitDeleteContact();
        page();
    }

    public void creation(ContactData contact, boolean b) {
        addNewContact();
        fillform( contact, b );
        submitContactCreation();
        page();
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String firtsname = cells.get(2).getText();
            String lastname = cells.get(1).getText();
            contacts.add(new ContactData().withId( id ).withFisrtname( firtsname ).withLastname( lastname ));
        }
        return contacts;
    }
}