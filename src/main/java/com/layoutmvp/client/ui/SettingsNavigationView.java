package com.layoutmvp.client.ui;


import com.google.gwt.user.client.ui.IsWidget;

public interface SettingsNavigationView extends IsWidget {

  void setPresenter(Presenter presenter);

  public interface Presenter {
  }

}
