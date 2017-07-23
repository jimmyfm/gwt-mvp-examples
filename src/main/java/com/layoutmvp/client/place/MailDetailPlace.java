package com.layoutmvp.client.place;

import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class MailDetailPlace extends MailPlace {
  private String mailId;

  public MailDetailPlace(String token) {
    this.mailId = token;
  }

  public String getMailId() {
    return mailId;
  }

  @Prefix("mail")
  public static class Tokenizer implements PlaceTokenizer<MailDetailPlace> {

    @Override
    public MailDetailPlace getPlace(String token) {
      return new MailDetailPlace(token);
    }

    @Override
    public String getToken(MailDetailPlace place) {
      return place.getMailId();
    }
  }

}
