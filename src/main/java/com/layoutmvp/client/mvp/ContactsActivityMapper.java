package com.layoutmvp.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.layoutmvp.client.ClientFactory;
import com.layoutmvp.client.activity.ContactDetailActivity;
import com.layoutmvp.client.place.ContactDetailPlace;
import com.layoutmvp.client.place.ContactListPlace;

public class ContactsActivityMapper implements ActivityMapper {
  private ClientFactory clientFactory;

  public ContactsActivityMapper(ClientFactory clientFactory) {
    this.clientFactory = clientFactory;
  }

  @Override
  public Activity getActivity(Place place) {
    if (place instanceof ContactListPlace) {
      return new ContactDetailActivity(null, clientFactory);
    } else if (place instanceof ContactDetailPlace) {
      return new ContactDetailActivity((ContactDetailPlace) place, clientFactory);
    }

    return null;
  }
}
