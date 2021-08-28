package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import java.util.List;

public class GroupDeletionTests extends TestBase {

  @org.testng.annotations.BeforeMethod
  public void ensurePreconditions(){
    app.goTo().GroupPage();
    if(app.group().list().size()==0){
      app.group().create(( new GroupData( "test1", null, null ) ));
    }
  }
  @Test
  public void testGroupDeletion() {
    List<GroupData> before=app.group().list();
    int index =before.size()-1;
    app.group().delete( index );
    List<GroupData> after = app.group().list();
    org.testng.Assert.assertEquals(after.size(),index);
    before.remove(index);
    org.testng.Assert.assertEquals(before,after);
    }



}
