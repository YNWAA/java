package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.goToContactPage();
    app.fillform( new ru.stqa.pft.addressbook.model.ContactData( "test1", "test2", "test3", "test4", "test5", "test6", "test7" ) );
    app.submitContactCreation();
  }

}
