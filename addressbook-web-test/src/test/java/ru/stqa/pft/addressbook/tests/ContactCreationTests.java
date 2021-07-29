package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().goToContactPage();
    int before=app.getContactHelper().getContactCount();
    app.getContactHelper().addNewContact();
    app.getContactHelper().fillform( new ContactData( "test1", "test2", "test3", "test4", "test5", "test6", "test7" ,"test1"),true );
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().goToContactPage();
    int after=app.getContactHelper().getContactCount();
    org.testng.Assert.assertEquals(after,before +1);
  }

}
