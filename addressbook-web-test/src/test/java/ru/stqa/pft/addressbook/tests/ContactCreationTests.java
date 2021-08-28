package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.List;
import org.testng.Assert;
import java.util.Comparator;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.contact().list();
    List<ContactData> before=app.contact().getContactList();
    ContactData contact=new ContactData( "test1", "test2", "test3", "test4", "test5", "test6", "test7" ,"test1");
    app.contact().modifyContactCreation( contact );
    List<ContactData> after=app.contact().getContactList();
    Assert.assertEquals(after.size(),before.size() +1);
    before.add( contact );
    Comparator<? super ContactData> byId = Comparator.comparingInt( ContactData::getId );
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }



}
