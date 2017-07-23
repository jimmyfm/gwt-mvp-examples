package com.layoutmvp.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.ui.client.adapters.ValueBoxEditor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ContactDetailViewImpl implements ContactDetailView {

  private final HTMLPanel contactDetailPanel;

  interface ContactDetailViewImplUiBinder extends UiBinder<HTMLPanel, ContactDetailViewImpl> {
  }

  private static ContactDetailViewImplUiBinder binder = GWT.create(ContactDetailViewImplUiBinder.class);

  @UiField
  TextBox name;
  @UiField
  TextBox address;

  public ContactDetailViewImpl() {
    contactDetailPanel = binder.createAndBindUi(this);
  }

  @Override
  public IsEditor<ValueBoxEditor<String>> getNameEditor() {
    return name;
  }

  @Override
  public IsEditor<ValueBoxEditor<String>> getAddressEditor() {
    return address;
  }

  @Override
  public Widget asWidget() {
    return contactDetailPanel;
  }
}
