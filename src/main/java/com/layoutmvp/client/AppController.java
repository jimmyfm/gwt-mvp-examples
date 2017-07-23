package com.layoutmvp.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.place.shared.PlaceController;
import com.layoutmvp.client.place.*;
import com.layoutmvp.client.ui.AppLayout;
import com.layoutmvp.client.ui.MainMenuView;
import com.layoutmvp.client.ui.MainMenuViewImpl;

public class AppController implements MainMenuView.Presenter {

  private final PlaceController placeController;

  public AppController(final AppLayout appLayout, ClientFactory clientFactory) {
    placeController = clientFactory.getPlaceController();
    MainMenuViewImpl mainMenutView = clientFactory.getMainMenuView();
    mainMenutView.setPresenter(this);
    EventBus eventBus = clientFactory.getEventBus();
    eventBus.addHandler(PlaceChangeEvent.TYPE, new HandlePlaceLayout(appLayout));
  }

  public void gotoContactListPlace() {
    placeController.goTo(new ContactListPlace());
  }

  public void gotoMailListPlace() {
    placeController.goTo(new MailListPlace());
  }

  public void gotoDefaultPlace() {
    placeController.goTo(new DefaultPlace());
  }

  public void gotoSettingsNavigationPlace() {
    placeController.goTo(new SettingsNavigationPlace());
  }

  private static class HandlePlaceLayout implements PlaceChangeEvent.Handler {
    private final AppLayout appLayout;

    public HandlePlaceLayout(AppLayout appLayout) {
      this.appLayout = appLayout;
    }

    @Override
    public void onPlaceChange(PlaceChangeEvent event) {
      Place newPlace = event.getNewPlace();
      if (newPlace instanceof MailPlace) {
        appLayout.setMailLayout();
      } else if (newPlace instanceof ContactPlace) {
        appLayout.setContactsLayout();
      } else if (newPlace instanceof SettingsNavigationPlace) {
        appLayout.setSettingsLayout();
      } else {
        appLayout.setDefaultLayout();
      }
    }
  }
}
