package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    goToContactPage();
    fillform( new ContactData( "test1", "test2", "test3", "test4", "test5", "test6", "test7" ) );
    submitContactCreation();
  }

}
