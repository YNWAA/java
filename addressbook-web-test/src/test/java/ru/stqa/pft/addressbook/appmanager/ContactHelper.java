package ru.stqa.pft.addressbook.appmanager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.ArrayList;
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

    public void createContact(ContactData contact) {
        addNewContact();
        fillform(contact,true);
        submitContactCreation();
        goToContactPage();
    }
    public List <ContactData> getContactList() {
        List<ContactData> contacts=new ArrayList<ContactData>();
        List<org.openqa.selenium.WebElement> elements=wd.findElements( By.name( "entry" ));
        for(org.openqa.selenium.WebElement element :elements){
            int id = Integer.parseInt( element.findElement( By.tagName( "input" ) ).getAttribute("value"));
            String firtsname = element.findElement(By.xpath( "td[3]" )).getText();
            String lastname = element.findElement(By.xpath( "td[2]" )).getText();
            ContactData contact=new ContactData(id,firtsname,null,lastname,null,null,null,null );
            contacts.add( contact );
        }
            return contacts;
        }
}
