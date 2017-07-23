package com.layoutmvp.client.place;

import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class ContactDetailPlace extends ContactPlace {
  private final String contactId;

  public ContactDetailPlace(String token) {
    this.contactId = token;
  }

  public String getContactId() {
    return contactId;
  }

  @Prefix("contact")
  public static class Tokenizer implements PlaceTokenizer<ContactDetailPlace> {

    @Override
    public ContactDetailPlace getPlace(String token) {
      return new ContactDetailPlace(token);
    }

    @Override
    public String getToken(ContactDetailPlace place) {
      return place.getContactId();
    }
  }

}
