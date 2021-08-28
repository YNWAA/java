package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.List;
import org.testng.Assert;

public class ContactDeletionTest extends TestBase {
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
    public void testContactDeletion(){
        List<ContactData> before = app.contact().list();
        int index =before.size()-1;
        app.contact().delete ( index );
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), index);
        before.remove(index);
        Assert.assertEquals(before, after);
    }


}