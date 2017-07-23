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
import com.layoutmvp.client.domain.Mail;

import java.util.List;

public class MailListViewImpl implements MailListView {
  private HTMLPanel mailListPanel;

  interface MailListViewImplUiBinder extends UiBinder<HTMLPanel, MailListViewImpl> {
  }

  private static MailListViewImplUiBinder binder = GWT.create(MailListViewImplUiBinder.class);

  private Presenter presenter;

  @UiField
  CellTable<Mail> table;

  public MailListViewImpl() {
    mailListPanel = binder.createAndBindUi(this);

    TextColumn<Mail> sender = new TextColumn<Mail>() {
      @Override
      public String getValue(Mail mail) {
        return mail.getSender();
      }
    };

    TextColumn<Mail> subject = new TextColumn<Mail>() {
      @Override
      public String getValue(Mail mail) {
        return mail.getSubject();
      }
    };

    table.addColumn(sender, "From");
    table.addColumn(subject, "Subject");

    // handle row selection
    final SingleSelectionModel<Mail> selectionModel = new SingleSelectionModel<Mail>();
    table.setSelectionModel(selectionModel);
    selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
      public void onSelectionChange(SelectionChangeEvent event) {
        Mail selected = selectionModel.getSelectedObject();
        if (selected != null) {
          presenter.mailSelected(selected.getId());
        }
      }
    });

  }

  @Override
  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;
  }

  public void setMailList(List<Mail> mailList) {
    table.setRowCount(mailList.size(), true);
    table.setRowData(0, mailList);
  }

  @Override
  public Widget asWidget() {
    return mailListPanel;
  }

}
