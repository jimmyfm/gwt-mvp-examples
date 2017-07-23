package com.layoutmvp.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.layoutmvp.client.mvp.*;
import com.layoutmvp.client.place.DefaultPlace;
import com.layoutmvp.client.ui.AppLayout;
import com.layoutmvp.client.ui.AppLayoutImpl;

public class LayoutMVP implements EntryPoint {

  private Place defaultPlace = new DefaultPlace();

  public void onModuleLoad() {

    ClientFactory clientFactory = GWT.create(ClientFactory.class);
    EventBus eventBus = clientFactory.getEventBus();

    AppLayout appLayout = new AppLayoutImpl(clientFactory);

    // Vertical Master container Activity Mapper
    CachingVerticalMasterActivityMapper vMasterActivityMapper = new CachingVerticalMasterActivityMapper(clientFactory);
    ActivityManager vMasterActivityManager = new ActivityManager(vMasterActivityMapper, eventBus);
    vMasterActivityManager.setDisplay(appLayout.getContactListContainer());

    // Horizontal Master container Activity Mapper
    CachingHorizontalMasterActivityMapper hMasterActivityMapper = new CachingHorizontalMasterActivityMapper(clientFactory);
    ActivityManager hMasterActivityManager = new ActivityManager(hMasterActivityMapper, eventBus);
    hMasterActivityManager.setDisplay(appLayout.getMailListContainer());

    // Side Content container Activity Mapper
    SideContainerActivityMapper sideContainerActivityMapper = new SideContainerActivityMapper(clientFactory);
    ActivityManager sideContainerActivityManager = new ActivityManager(sideContainerActivityMapper, eventBus);
    sideContainerActivityManager.setDisplay(appLayout.getSettingsContainer());

    // Main Content container Activity Mapper
    MainContentActivityMapper mainContentContainerActivityMapper = new MainContentActivityMapper(clientFactory);
    ActivityManager mainContentContainerActivityManager = new ActivityManager(mainContentContainerActivityMapper, eventBus);
    mainContentContainerActivityManager.setDisplay(appLayout.getMainContainer());

    AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);

    PlaceController placeController = clientFactory.getPlaceController();
    PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
    historyHandler.register(placeController, eventBus, defaultPlace);

    RootLayoutPanel.get().add(appLayout.getMainLayoutPanel());
    AppController appController = new AppController(appLayout, clientFactory);

    historyHandler.handleCurrentHistory();
  }

}