package com.layoutmvp.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.layoutmvp.client.ClientFactory;
import com.layoutmvp.client.ui.SettingsNavigationView;

public class SettingsActivity extends AbstractActivity implements SettingsNavigationView.Presenter {

  private final SettingsNavigationView view;

  public SettingsActivity(ClientFactory clientFactory) {
    view = clientFactory.getSettingsNavigationView();
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    view.setPresenter(this);
    panel.setWidget(view.asWidget());
  }

}
