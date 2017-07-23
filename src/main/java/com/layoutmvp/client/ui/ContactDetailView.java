package com.layoutmvp.client.ui;

import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.ui.client.adapters.ValueBoxEditor;
import com.google.gwt.user.client.ui.IsWidget;
import com.layoutmvp.client.domain.Contact;

public interface ContactDetailView extends IsWidget, Editor<Contact> {
  @Path("name")
  IsEditor<ValueBoxEditor<String>> getNameEditor();

  @Path("address")
  IsEditor<ValueBoxEditor<String>> getAddressEditor();

}
