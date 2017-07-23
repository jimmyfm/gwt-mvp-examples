package com.layoutmvp.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.activity.shared.CachingActivityMapper;
import com.google.gwt.activity.shared.FilteredActivityMapper;
import com.google.gwt.place.shared.Place;
import com.layoutmvp.client.ClientFactory;
import com.layoutmvp.client.place.ContactListPlace;
import com.layoutmvp.client.place.ContactDetailPlace;

public class CachingVerticalMasterActivityMapper implements ActivityMapper {

  private ActivityMapper filteredActivityMapper;

  public CachingVerticalMasterActivityMapper(ClientFactory clientFactory) {

    FilteredActivityMapper.Filter filter = new FilteredActivityMapper.Filter() {
      @Override
      public Place filter(Place place) {
        return place instanceof ContactDetailPlace ? new ContactListPlace() : place;
      }
    };

    VerticalMasterActivityMapper mapper = new VerticalMasterActivityMapper(clientFactory);
    CachingActivityMapper cachingActivityMapper = new CachingActivityMapper(mapper);
    filteredActivityMapper = new FilteredActivityMapper(filter, cachingActivityMapper);
  }

  @Override
  public Activity getActivity(Place place) {
    return filteredActivityMapper.getActivity(place);
  }
}
