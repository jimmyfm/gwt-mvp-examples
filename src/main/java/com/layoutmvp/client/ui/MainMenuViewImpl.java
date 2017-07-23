package com.layoutmvp.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

public class MainMenuViewImpl extends Composite implements MainMenuView {
  private Presenter presenter;

  interface MainMenuUiBinder extends UiBinder<FlowPanel, MainMenuViewImpl> {
  }

  private static MainMenuUiBinder binder = GWT.create(MainMenuUiBinder.class);

  @UiField
  Button defaultButton;

  @UiField
  Button mailButton;

  @UiField
  Button contactButton;

  @UiField
  Button settingsButton;

  public MainMenuViewImpl() {
    FlowPanel panel = binder.createAndBindUi(this);
    initWidget(panel);
  }

  @Override
  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;
  }

  @UiHandler("defaultButton")
  void defaultLayoutClicked(ClickEvent e) {
    presenter.gotoDefaultPlace();
  }

  @UiHandler("contactButton")
  void vmdLayoutClicked(ClickEvent e) {
    presenter.gotoContactListPlace();
  }

  @UiHandler("mailButton")
  void hmdLayoutClicked(ClickEvent e) {
    presenter.gotoMailListPlace();
  }

  @UiHandler("settingsButton")
  void spLayoutClicked(ClickEvent e) {
    presenter.gotoSettingsNavigationPlace();
  }

}