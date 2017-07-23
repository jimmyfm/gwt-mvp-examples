package com.layoutmvp.client.ui;


import com.google.gwt.user.client.ui.IsWidget;

public interface MainMenuView extends IsWidget {

  void setPresenter(Presenter presenter);

  public interface Presenter {
    void gotoDefaultPlace();

    void gotoContactListPlace();

    void gotoMailListPlace();

    void gotoSettingsNavigationPlace();
  }
}
