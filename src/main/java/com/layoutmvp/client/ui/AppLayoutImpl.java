package com.layoutmvp.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.layoutmvp.client.ClientFactory;

import static com.google.gwt.dom.client.Style.Unit.PCT;

public class AppLayoutImpl implements AppLayout {

  private static final int MAINMENU_HEIGHT = 10;
  private static final int HMASTER_HEIGHT = 30;
  private static final int ASIDE_WIDTH = 25;
  private static final int VMASTER_WIDTH = 20;

  private final LayoutPanel mainLayoutPanel;

  interface AppLayoutUiBinder extends UiBinder<LayoutPanel, AppLayoutImpl> {
  }

  private static AppLayoutUiBinder binder = GWT.create(AppLayoutUiBinder.class);

  @UiField
  SimplePanel menuPanel;

  @UiField
  SimplePanel mvPanel;

  @UiField
  SimplePanel mhPanel;

  @UiField
  SimplePanel sidePanel;

  @UiField
  SimplePanel mainPanel;

  @UiField(provided = true)
  MainMenuViewImpl mainMenu;

  public AppLayoutImpl(ClientFactory clientFactory) {
    mainMenu = clientFactory.getMainMenuView();
    mainLayoutPanel = binder.createAndBindUi(this);
    setDefaultLayout();
  }

  @Override
  public LayoutPanel getMainLayoutPanel() {
    return mainLayoutPanel;
  }

  @Override
  public AcceptsOneWidget getContactListContainer() {
    return new AcceptsOneWidget() {
      @Override
      public void setWidget(IsWidget w) {
        Widget widget = Widget.asWidgetOrNull(w);
        mvPanel.setWidget(widget);
      }
    };
  }

  @Override
  public AcceptsOneWidget getMainContainer() {
    return new AcceptsOneWidget() {
      @Override
      public void setWidget(IsWidget w) {
        Widget widget = Widget.asWidgetOrNull(w);
        mainPanel.setWidget(widget);
      }
    };
  }

  @Override
  public AcceptsOneWidget getMailListContainer() {
    return new AcceptsOneWidget() {
      @Override
      public void setWidget(IsWidget w) {
        Widget widget = Widget.asWidgetOrNull(w);
        mhPanel.setWidget(widget);
      }
    };
  }

  @Override
  public AcceptsOneWidget getSettingsContainer() {
    return new AcceptsOneWidget() {
      @Override
      public void setWidget(IsWidget w) {
        Widget widget = Widget.asWidgetOrNull(w);
        sidePanel.setWidget(widget);
      }
    };
  }

  public void setMailLayout() {
    int top = MAINMENU_HEIGHT + HMASTER_HEIGHT;
    mainLayoutPanel.setWidgetTopHeight(mhPanel, MAINMENU_HEIGHT, PCT, HMASTER_HEIGHT, PCT);
    mainLayoutPanel.setWidgetLeftWidth(mvPanel, 0, PCT, 0, PCT);
    mainLayoutPanel.setWidgetLeftWidth(mainPanel, 0, PCT, 100, PCT);
    mainLayoutPanel.setWidgetTopHeight(mainPanel, top, PCT, 100 - top, PCT);
    mainLayoutPanel.setWidgetRightWidth(sidePanel, 0, PCT, 0, PCT);
    mainLayoutPanel.animate(500);
  }

  public void setContactsLayout() {
    int height = 100 - MAINMENU_HEIGHT;
    mainLayoutPanel.setWidgetTopHeight(mhPanel, 0, PCT, 0, PCT);
    mainLayoutPanel.setWidgetTopHeight(mvPanel, MAINMENU_HEIGHT, PCT, height, PCT);
    mainLayoutPanel.setWidgetLeftWidth(mvPanel, 0, PCT, VMASTER_WIDTH, PCT);
    mainLayoutPanel.setWidgetTopHeight(mainPanel, MAINMENU_HEIGHT, PCT, height, PCT);
    mainLayoutPanel.setWidgetLeftWidth(mainPanel, VMASTER_WIDTH, PCT, 100 - VMASTER_WIDTH, PCT);
    mainLayoutPanel.setWidgetRightWidth(sidePanel, 0, PCT, 0, PCT);
    mainLayoutPanel.animate(500);
  }

  public void setDefaultLayout() {
    int height = 100 - MAINMENU_HEIGHT;
    mainLayoutPanel.setWidgetTopHeight(menuPanel, 0, PCT, MAINMENU_HEIGHT, PCT);
    mainLayoutPanel.setWidgetTopHeight(mvPanel, 0, PCT, 0, PCT);
    mainLayoutPanel.setWidgetTopHeight(mhPanel, 0, PCT, 0, PCT);
    mainLayoutPanel.setWidgetRightWidth(sidePanel, 0, PCT, 0, PCT);
    mainLayoutPanel.setWidgetTopHeight(mainPanel, MAINMENU_HEIGHT, PCT, height, PCT);
    mainLayoutPanel.setWidgetLeftWidth(mainPanel, 0, PCT, 100, PCT);
    mainLayoutPanel.animate(500);
  }

  public void setSettingsLayout() {
    int height = 100 - MAINMENU_HEIGHT;
    mainLayoutPanel.setWidgetTopHeight(mhPanel, 0, PCT, 0, PCT);
    mainLayoutPanel.setWidgetLeftWidth(mvPanel, 0, PCT, 0, PCT);
    mainLayoutPanel.setWidgetLeftWidth(mainPanel, 0, PCT, 100 - ASIDE_WIDTH, PCT);
    mainLayoutPanel.setWidgetTopHeight(mainPanel, MAINMENU_HEIGHT, PCT, height, PCT);
    mainLayoutPanel.setWidgetTopHeight(sidePanel, MAINMENU_HEIGHT, PCT, height, PCT);
    mainLayoutPanel.setWidgetRightWidth(sidePanel, 0, PCT, ASIDE_WIDTH, PCT);
    mainLayoutPanel.animate(500);
  }
}