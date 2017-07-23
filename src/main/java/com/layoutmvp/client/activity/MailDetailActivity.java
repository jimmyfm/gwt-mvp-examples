package com.layoutmvp.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.layoutmvp.client.ClientFactory;
import com.layoutmvp.client.domain.Mail;
import com.layoutmvp.client.place.MailDetailPlace;
import com.layoutmvp.client.ui.MailDetailView;

import static com.layoutmvp.client.domain.Mail.MAILLIST;

public class MailDetailActivity extends AbstractActivity {

  interface EditorDriver extends SimpleBeanEditorDriver<Mail, MailDetailView> {
  }

  private final EditorDriver editor;
  private final MailDetailView view;
  private final int mailId;

  public MailDetailActivity(MailDetailPlace place, ClientFactory clientFactory) {
    view = clientFactory.getMailDetailView();
    editor = GWT.create(EditorDriver.class);
    editor.initialize(view);
    mailId = (place == null) ? 0 : Integer.valueOf(place.getMailId());
  }

  @Override
  public void start(AcceptsOneWidget container, EventBus eventBus) {
    Mail mail = MAILLIST.getMail(mailId);
    edit(mail);
    container.setWidget(view);
  }

  private void edit(Mail mail) {
    if (mail != null) {
      editor.edit(mail);
    }
  }

}
