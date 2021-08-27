package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @org.testng.annotations.Test
  public void testContactCreation() {
    app.getContactHelper().goToContactPage();
    java.util.List<ContactData> before=app.getContactHelper().getContactList();
    ContactData contact=new ru.stqa.pft.addressbook.model.ContactData( "test1", "test2", "test3", "test4", "test5", "test6", "test7" ,"test1");
    app.getContactHelper().addNewContact();
    app.getContactHelper().fillform(contact,true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().goToContactPage();
    java.util.List<ContactData> after=app.getContactHelper().getContactList();
    org.testng.Assert.assertEquals(after.size(),before.size() +1);
    before.add( contact );
    java.util.Comparator<? super ContactData> byId = java.util.Comparator.comparingInt( ru.stqa.pft.addressbook.model.ContactData::getId );
    before.sort(byId);
    after.sort(byId);
    org.testng.Assert.assertEquals(before, after);
  }

}
