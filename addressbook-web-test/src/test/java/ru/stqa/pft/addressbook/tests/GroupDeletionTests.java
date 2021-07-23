package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().goToGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(( new ru.stqa.pft.addressbook.model.GroupData( "test1", null, null ) ));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectGroup();
    app.getGroupHelper().returnToGroupPage();
    }

}
