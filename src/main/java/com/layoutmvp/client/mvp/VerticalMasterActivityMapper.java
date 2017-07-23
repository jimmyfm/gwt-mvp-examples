package com.layoutmvp.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.layoutmvp.client.ClientFactory;
import com.layoutmvp.client.activity.ContactListActivity;
import com.layoutmvp.client.place.ContactListPlace;

public class VerticalMasterActivityMapper implements ActivityMapper {

  private ClientFactory clientFactory;

  public VerticalMasterActivityMapper(ClientFactory clientFactory) {
    this.clientFactory = clientFactory;
  }

  public Activity getActivity(Place place) {

    if (place instanceof ContactListPlace) {
      return new ContactListActivity(clientFactory);
    }

    return null;
  }
}
