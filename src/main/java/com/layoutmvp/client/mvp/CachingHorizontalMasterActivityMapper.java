package com.layoutmvp.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.activity.shared.CachingActivityMapper;
import com.google.gwt.activity.shared.FilteredActivityMapper;
import com.google.gwt.place.shared.Place;
import com.layoutmvp.client.ClientFactory;
import com.layoutmvp.client.place.MailDetailPlace;
import com.layoutmvp.client.place.MailListPlace;

public class CachingHorizontalMasterActivityMapper implements ActivityMapper {

  private ActivityMapper filteredActivityMapper;

  public CachingHorizontalMasterActivityMapper(ClientFactory clientFactory) {

    FilteredActivityMapper.Filter filter = new FilteredActivityMapper.Filter() {
      @Override
      public Place filter(Place place) {
        return place instanceof MailDetailPlace ? new MailListPlace() : place;
      }
    };

    HorizontalMasterActivityMapper mapper = new HorizontalMasterActivityMapper(clientFactory);
    CachingActivityMapper cachingActivityMapper = new CachingActivityMapper(mapper);
    filteredActivityMapper = new FilteredActivityMapper(filter, cachingActivityMapper);
  }

  @Override
  public Activity getActivity(Place place) {
    return filteredActivityMapper.getActivity(place);
  }
}
