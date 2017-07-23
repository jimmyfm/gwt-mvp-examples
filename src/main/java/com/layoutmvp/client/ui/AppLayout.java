package com.layoutmvp.client.ui;


import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.LayoutPanel;

public interface AppLayout {

  LayoutPanel getMainLayoutPanel();

  AcceptsOneWidget getContactListContainer();

  AcceptsOneWidget getMainContainer();

  AcceptsOneWidget getMailListContainer();

  AcceptsOneWidget getSettingsContainer();

  void setDefaultLayout();

  void setContactsLayout();

  void setMailLayout();

  void setSettingsLayout();

}
