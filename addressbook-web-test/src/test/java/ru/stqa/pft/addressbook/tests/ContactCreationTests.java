package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.List;
import org.testng.Assert;
import java.util.Comparator;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().contactPage();
    List<ContactData> before=app.contact().list();
    ContactData contact=new ContactData().withFisrtname("test1")
            .withMiddlename( "test2" ).withLastname( "test3" ).withNickname( "test4" )
            .withAddress("test5"  ).withHome("test6").withEmail( "test7").withGroup( "test1" );
    app.contact().creation( contact );
    List<ContactData> after=app.contact().list();
    Assert.assertEquals(after.size(),before.size() +1);
    before.add( contact );
    Comparator<? super ContactData> byId = Comparator.comparingInt( ContactData::getId );
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }



}
