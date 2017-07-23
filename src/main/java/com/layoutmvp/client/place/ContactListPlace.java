package com.layoutmvp.client.place;

import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class ContactListPlace extends ContactPlace {

  private static final String PREFIX = "contacts";

  /**
   * equality test based on Class type, to let different instance of this
   * Place class to be equals for CachingActivityMapper test on Place equality
   *
   * @param otherPlace the place to compare with
   * @return true if this place and otherPlace are of the same Class type
   */
  @Override
  public boolean equals(Object otherPlace) {
    return this == otherPlace || (otherPlace != null && getClass() == otherPlace.getClass());
  }

  @Override
  public int hashCode() {
    return PREFIX.hashCode();
  }

  @Prefix(PREFIX)
  public static class Tokenizer implements PlaceTokenizer<ContactListPlace> {

    @Override
    public ContactListPlace getPlace(String token) {
      return new ContactListPlace();
    }

    @Override
    public String getToken(ContactListPlace place) {
      return PREFIX;
    }
  }

}
