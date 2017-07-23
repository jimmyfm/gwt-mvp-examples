package com.layoutmvp.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.layoutmvp.client.ClientFactory;
import com.layoutmvp.client.activity.MailDetailActivity;
import com.layoutmvp.client.place.MailDetailPlace;
import com.layoutmvp.client.place.MailListPlace;

public class MailActivityMapper implements ActivityMapper {

  private ClientFactory clientFactory;

  public MailActivityMapper(ClientFactory clientFactory) {
    this.clientFactory = clientFactory;
  }

  @Override
  public Activity getActivity(Place place) {
    if (place instanceof MailListPlace) {
      return new MailDetailActivity(null, clientFactory);
    }

    if (place instanceof MailDetailPlace) {
      return new MailDetailActivity((MailDetailPlace) place, clientFactory);
    }

    return null;
  }
}
