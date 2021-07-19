package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().addNewContact();
    app.getContactHelper().fillform( new ContactData( "test1", "test2", "test3", "test4", "test5", "test6", "test7" ) );
    app.getContactHelper().submitContactCreation();
  }

}
