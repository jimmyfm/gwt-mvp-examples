package com.layoutmvp.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.layoutmvp.client.ClientFactory;
import com.layoutmvp.client.place.ContactPlace;
import com.layoutmvp.client.place.MailPlace;

public class MainContentActivityMapper implements ActivityMapper {

  private final MailActivityMapper mailActivityMapper;
  private final ContactsActivityMapper contactsActivityMapper;

  public MainContentActivityMapper(ClientFactory clientFactory) {
    mailActivityMapper = new MailActivityMapper(clientFactory);
    contactsActivityMapper = new ContactsActivityMapper(clientFactory);
  }

  public Activity getActivity(Place place) {

    if (place instanceof MailPlace) {
      return mailActivityMapper.getActivity(place);
    }

    if (place instanceof ContactPlace) {
      return contactsActivityMapper.getActivity(place);
    }

    return null;
  }
}
