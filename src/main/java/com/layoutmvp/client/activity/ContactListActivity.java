package com.layoutmvp.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.layoutmvp.client.ClientFactory;
import com.layoutmvp.client.place.ContactDetailPlace;
import com.layoutmvp.client.ui.ContactListView;

import static com.layoutmvp.client.domain.Contact.CONTACTS;

public class ContactListActivity extends AbstractActivity implements ContactListView.Presenter {

  private final ContactListView view;

  private final PlaceController placeController;

  public ContactListActivity(ClientFactory clientFactory) {
    view = clientFactory.getContactListView();
    placeController = clientFactory.getPlaceController();
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    view.setPresenter(this);
    view.setContactList(CONTACTS.getContactList());
    panel.setWidget(view.asWidget());
  }

  @Override
  public void contactSelected(int id) {
    placeController.goTo(new ContactDetailPlace(Integer.toString(id)));
  }

}
