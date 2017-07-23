package com.layoutmvp.client.mvp;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.layoutmvp.client.place.*;

@WithTokenizers({
    DefaultPlace.Tokenizer.class,
    ContactListPlace.Tokenizer.class,
    ContactDetailPlace.Tokenizer.class,
    MailListPlace.Tokenizer.class,
    MailDetailPlace.Tokenizer.class,
    SettingsNavigationPlace.Tokenizer.class
})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
