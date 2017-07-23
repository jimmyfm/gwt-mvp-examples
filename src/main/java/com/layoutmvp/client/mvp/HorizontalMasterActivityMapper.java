package com.layoutmvp.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.layoutmvp.client.ClientFactory;
import com.layoutmvp.client.activity.MailListActivity;
import com.layoutmvp.client.place.MailListPlace;

public class HorizontalMasterActivityMapper implements ActivityMapper {

  private ClientFactory clientFactory;

  public HorizontalMasterActivityMapper(ClientFactory clientFactory) {
    this.clientFactory = clientFactory;
  }

  public Activity getActivity(Place place) {
    if (place instanceof MailListPlace) {
      return new MailListActivity(clientFactory);
    }

    return null;
  }
}
