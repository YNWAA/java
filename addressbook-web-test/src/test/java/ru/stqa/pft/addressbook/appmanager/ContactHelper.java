package ru.stqa.pft.addressbook.appmanager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;
public class ContactHelper extends HelperBase {
    public ContactHelper(org.openqa.selenium.WebDriver wd) {
        super( wd );
    }


    public void fillform(ContactData contactData,boolean creation) {
        type( By.name( "firstname" ), contactData.getFisrtname() );
        type( By.name( "middlename" ), contactData.getMiddlename() );
        type( By.name( "lastname" ), contactData.getLastname() );
        type( By.name( "nickname" ), contactData.getNickname() );
        type( By.name( "address" ), contactData.getAddress() );
        type( By.name( "home" ), contactData.getHome() );
        type( By.name( "email" ), contactData.getEmail() );
        if (creation) {
            if (!  wd.findElement( org.openqa.selenium.By.tagName( "option" ) ).getText().equals( contactData.getGroup() )) {
                new Select( wd.findElement( By.name( "new_group" ) ) ).selectByVisibleText( "[none]" );
            } else {
                new Select( wd.findElement( By.name( "new_group" ) ) ).selectByVisibleText( contactData.getGroup() );
            }
        } else {
            org.testng.Assert.assertFalse( isElementPresent( By.name( "new_group" ) ) );
        }
    }
    public void submitContactCreation() {
        click( By.xpath("//div[@id='content']/form/input[21]") );
    }

    public void selectContact(int index) {
        wd.findElements( By.name("selected[]") ).get( index ).click();
    }

    public void deleteContact() {
        click( By.xpath("//input[@value='Delete']") );
    }

    public void submitDeleteContact() {
        wd.switchTo().alert().accept();
        wd.findElement(By.cssSelector("div.msgbox"));
    }

    public void selectContactModification(int index) {
        wd.findElements(By.xpath("//img[@alt='Edit']") ).get( index ).click();

    }

    public void updateContactModification() {
        click( org.openqa.selenium.By.name("update") );

    }
    public boolean isThereAGroup() {
        return isElementPresent( By.name("selected[]") );
    }
    public void goToContactPage() {
        if(isElementPresent( By.id( "maintable" ) )){
            return;
        }
        click( By.linkText("home") );
    }
    public void addNewContact() {
        click( By.linkText("add new"));
    }

    public void createContact(ru.stqa.pft.addressbook.model.ContactData contact) {
        addNewContact();
        fillform(contact,true);
        submitContactCreation();
        goToContactPage();
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")  ).size();
    }
}
