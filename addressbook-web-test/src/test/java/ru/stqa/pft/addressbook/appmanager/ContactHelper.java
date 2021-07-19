package ru.stqa.pft.addressbook.appmanager;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;
public class ContactHelper extends HelperBase {
    public ContactHelper(FirefoxDriver wd) {
        super( wd );
    }


    public void fillform(ContactData contactData) {
        type( By.name( "firstname" ), contactData.getFisrtname() );
        type( By.name( "middlename" ), contactData.getMiddlename() );
        type( By.name( "lastname" ), contactData.getLastname() );
        type( By.name( "nickname" ), contactData.getNickname() );
        type( By.name( "address" ), contactData.getAddress() );
        type( By.name( "home" ), contactData.getHome() );
        type( By.name( "email" ), contactData.getEmail() );
    }

    public void submitContactCreation() {
        click( By.xpath("//div[@id='content']/form/input[21]") );
    }

    public void selectContact() {
        click( By.name("selected[]") );
    }

    public void deleteContact() {
        click( By.xpath("//input[@value='Delete']") );
    }

    public void submitDeleteContact() {
        wd.switchTo().alert().accept();
        wd.findElement(By.cssSelector("div.msgbox"));
    }

    public void selectContactModification() {
        click( org.openqa.selenium.By.xpath("//img[@alt='Edit']") );

    }

    public void updateContactModification() {
        click( org.openqa.selenium.By.name("update") );

    }
}
