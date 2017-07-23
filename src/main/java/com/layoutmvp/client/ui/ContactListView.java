package com.layoutmvp.client.ui;


import com.google.gwt.user.client.ui.IsWidget;
import com.layoutmvp.client.domain.Contact;

import java.util.List;

public interface ContactListView extends IsWidget {
  void setContactList(List<Contact> contactList);

  void setPresenter(Presenter presenter);

  public interface Presenter {
    void contactSelected(int id);
  }
}
