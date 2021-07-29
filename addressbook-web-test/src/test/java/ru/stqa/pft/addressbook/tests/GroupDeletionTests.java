package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().goToGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(( new ru.stqa.pft.addressbook.model.GroupData( "test1", null, null ) ));
    }
    int before=app.getGroupHelper().getGroupCount();
    app.getGroupHelper().selectGroup(before -1);
    app.getGroupHelper().deleteSelectGroup();
    app.getGroupHelper().returnToGroupPage();
    int after=app.getGroupHelper().getGroupCount();
    org.testng.Assert.assertEquals(after,before -1);
    }

}
