package com.layoutmvp.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.layoutmvp.client.ui.*;

public interface ClientFactory {
  EventBus getEventBus();

  PlaceController getPlaceController();

  ContactListView getContactListView();

  ContactDetailView getContactDetailView();

  MailListView getMailListView();

  MailDetailView getMailDetailView();

  SettingsNavigationView getSettingsNavigationView();

  MainMenuViewImpl getMainMenuView();

}
