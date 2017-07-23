package com.layoutmvp.client.ui;


import com.google.gwt.user.client.ui.IsWidget;
import com.layoutmvp.client.domain.Mail;

import java.util.List;

public interface MailListView extends IsWidget {
  void setMailList(List<Mail> mailList);

  void setPresenter(Presenter presenter);

  public interface Presenter {
    void mailSelected(int id);
  }
}
