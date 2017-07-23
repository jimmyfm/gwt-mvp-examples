package com.layoutmvp.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.layoutmvp.client.domain.Contact;

import java.util.List;

public class ContactListViewImpl implements ContactListView {
  private HTMLPanel contactListPanel;

  interface ContactListViewImplUiBinder extends UiBinder<HTMLPanel, ContactListViewImpl> {
  }

  private static ContactListViewImplUiBinder binder = GWT.create(ContactListViewImplUiBinder.class);

  private Presenter presenter;

  @UiField
  CellTable<Contact> table;

  public ContactListViewImpl() {
    contactListPanel = binder.createAndBindUi(this);

    TextColumn<Contact> nameColumn = new TextColumn<Contact>() {
      @Override
      public String getValue(Contact contact) {
        return contact.getName();
      }
    };

    TextColumn<Contact> addressColumn = new TextColumn<Contact>() {
      @Override
      public String getValue(Contact contact) {
        return contact.getAddress();
      }
    };

    table.addColumn(nameColumn, "Name");
    table.addColumn(addressColumn, "Address");

    // handle row selection
    final SingleSelectionModel<Contact> selectionModel = new SingleSelectionModel<Contact>();
    table.setSelectionModel(selectionModel);
    selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
      public void onSelectionChange(SelectionChangeEvent event) {
        Contact selected = selectionModel.getSelectedObject();
        if (selected != null) {
          presenter.contactSelected(selected.getId());
        }
      }
    });
  }

  @Override
  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;
  }

  public void setContactList(List<Contact> contactList) {
    table.setRowCount(contactList.size(), true);
    table.setRowData(0, contactList);
  }

  @Override
  public Widget asWidget() {
    return contactListPanel;
  }

}
