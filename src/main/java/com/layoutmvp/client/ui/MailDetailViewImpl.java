package com.layoutmvp.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.ui.client.adapters.ValueBoxEditor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class MailDetailViewImpl implements MailDetailView {

  private final HTMLPanel mailDetailPanel;

  interface MailDetailViewImplUiBinder extends UiBinder<HTMLPanel, MailDetailViewImpl> {
  }

  private static MailDetailViewImplUiBinder binder = GWT.create(MailDetailViewImplUiBinder.class);

  @UiField
  TextBox sender;
  @UiField
  TextBox subject;
  @UiField
  TextArea body;

  public MailDetailViewImpl() {
    mailDetailPanel = binder.createAndBindUi(this);
  }

  @Override
  public IsEditor<ValueBoxEditor<String>> getSenderEditor() {
    return sender;
  }

  @Override
  public IsEditor<ValueBoxEditor<String>> getSubjectEditor() {
    return subject;
  }

  @Override
  public IsEditor<ValueBoxEditor<String>> getBodyEditor() {
    return body;
  }

  @Override
  public Widget asWidget() {
    return mailDetailPanel;
  }
}
