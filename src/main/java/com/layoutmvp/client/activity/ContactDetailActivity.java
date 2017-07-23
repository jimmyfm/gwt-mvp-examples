package com.layoutmvp.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.layoutmvp.client.ClientFactory;
import com.layoutmvp.client.domain.Contact;
import com.layoutmvp.client.place.ContactDetailPlace;
import com.layoutmvp.client.ui.ContactDetailView;

import static com.layoutmvp.client.domain.Contact.CONTACTS;

public class ContactDetailActivity extends AbstractActivity {

  interface EditorDriver extends SimpleBeanEditorDriver<Contact, ContactDetailView> {
  }

  private final EditorDriver editor;
  private final ContactDetailView view;
  private final int contactId;

  public ContactDetailActivity(ContactDetailPlace place, ClientFactory clientFactory) {
    view = clientFactory.getContactDetailView();
    editor = GWT.create(EditorDriver.class);
    editor.initialize(view);
    contactId = (place == null) ? 0 : Integer.valueOf(place.getContactId());
  }

  @Override
  public void start(AcceptsOneWidget container, EventBus eventBus) {
    Contact contact = CONTACTS.getContact(contactId);
    edit(contact);
    container.setWidget(view);
  }

  private void edit(Contact contact) {
    if (contact != null) {
      editor.edit(contact);
    }
  }

}
