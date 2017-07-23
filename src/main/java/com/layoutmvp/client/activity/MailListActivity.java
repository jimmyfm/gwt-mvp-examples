package com.layoutmvp.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.layoutmvp.client.ClientFactory;
import com.layoutmvp.client.place.MailDetailPlace;
import com.layoutmvp.client.ui.MailListView;

import static com.layoutmvp.client.domain.Mail.MAILLIST;

public class MailListActivity extends AbstractActivity implements MailListView.Presenter {

  private final MailListView view;

  private final PlaceController placeController;

  public MailListActivity(ClientFactory clientFactory) {
    view = clientFactory.getMailListView();
    placeController = clientFactory.getPlaceController();
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    view.setPresenter(this);
    view.setMailList(MAILLIST.getMailList());
    panel.setWidget(view.asWidget());
  }

  @Override
  public void mailSelected(int id) {
    placeController.goTo(new MailDetailPlace(Integer.toString(id)));
  }
}
