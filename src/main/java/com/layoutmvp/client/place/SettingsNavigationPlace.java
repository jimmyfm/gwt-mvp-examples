package com.layoutmvp.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class SettingsNavigationPlace extends Place {

  @Prefix("settings")
  public static class Tokenizer implements PlaceTokenizer<SettingsNavigationPlace> {

    @Override
    public SettingsNavigationPlace getPlace(String token) {
      return new SettingsNavigationPlace();
    }

    @Override
    public String getToken(SettingsNavigationPlace place) {
      return "list";
    }
  }

}
