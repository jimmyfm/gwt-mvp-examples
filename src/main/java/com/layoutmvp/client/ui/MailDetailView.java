package com.layoutmvp.client.ui;

import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.ui.client.adapters.ValueBoxEditor;
import com.google.gwt.user.client.ui.IsWidget;
import com.layoutmvp.client.domain.Mail;

public interface MailDetailView extends IsWidget, Editor<Mail> {

  @Path("sender")
  IsEditor<ValueBoxEditor<String>> getSenderEditor();

  @Path("subject")
  IsEditor<ValueBoxEditor<String>> getSubjectEditor();

  @Path("body")
  IsEditor<ValueBoxEditor<String>> getBodyEditor();

}
