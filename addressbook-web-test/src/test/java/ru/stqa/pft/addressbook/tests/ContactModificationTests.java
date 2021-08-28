package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.List;
import org.testng.Assert;
import java.util.Comparator;

public class ContactModificationTests extends TestBase {
    @org.testng.annotations.BeforeMethod
    public void ensurePreconditions(){
        app.goTo().contactPage();
        if( app.contact().list().size()==0){
            app.contact().create(( new ContactData().withFisrtname("test1")
                    .withMiddlename( "test2" ).withLastname( "test3" ).withNickname( "test4" )
                    .withAddress("test5"  ).withHome("test6").withEmail( "test7").withGroup( "test1" )));
        }
    }
    @Test
    public void testContactModification() {
        List<ContactData> before = app.contact().list();
        ContactData contact=new ContactData().withFisrtname("test1")
                .withMiddlename( "test2" ).withLastname( "test3" ).withNickname( "test4" )
                .withAddress("test5"  ).withHome("test6").withEmail( "test7").withGroup( "test1" );
        int index =before.size()-1;
        app.contact().modify( index, contact );
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(),before.size());
        before.remove(index);
        Comparator<? super ContactData> byId = (Comparator<ContactData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        before.add(contact);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
        Assert.assertEquals(new java.util.HashSet<Object>(before),new java.util.HashSet<Object>(after));
    }



}
