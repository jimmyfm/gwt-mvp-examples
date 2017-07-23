package com.layoutmvp.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.Widget;


public class SettingsNavigationViewImpl implements SettingsNavigationView {

  private final StackLayoutPanel stackLayoutPanel;
  private Presenter presenter;

  interface SettingsListViewImplUiBinder extends UiBinder<StackLayoutPanel, SettingsNavigationViewImpl> {
  }

  private static SettingsListViewImplUiBinder binder = GWT.create(SettingsListViewImplUiBinder.class);

  @UiField
  Label contactsPreferences;

  @UiField
  Label mailPreferences;

  public SettingsNavigationViewImpl() {
    stackLayoutPanel = binder.createAndBindUi(this);
  }

  @Override
  public Widget asWidget() {
    return stackLayoutPanel;
  }

  @Override
  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;
  }
}