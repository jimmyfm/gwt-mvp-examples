package com.layoutmvp.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.layoutmvp.client.ClientFactory;
import com.layoutmvp.client.activity.SettingsActivity;
import com.layoutmvp.client.place.SettingsNavigationPlace;

public class SideContainerActivityMapper implements ActivityMapper {

  private ClientFactory clientFactory;

  public SideContainerActivityMapper(ClientFactory clientFactory) {
    this.clientFactory = clientFactory;
  }

  public Activity getActivity(Place place) {

    if (place instanceof SettingsNavigationPlace) {
      return new SettingsActivity(clientFactory);
    }

    return null;
  }
}
