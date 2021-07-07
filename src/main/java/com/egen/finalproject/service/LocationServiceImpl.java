/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.egen.finalproject.service;

import com.egen.finalproject.model.Location;
import com.egen.finalproject.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Page<Location> getAllLocations(int pageNo, int pageSize, String sortBy){
        return locationRepository.findAll(PageRequest.of( pageNo, pageSize, Sort.by("locationName")));
    }

    public Location saveLocation(Location location){
        return (locationRepository.save(location));
    }

    public Location updateLocation(Location location){
        Optional<Location> existingLocation = locationRepository.findById(location.getLocationId());
        return locationRepository.save(location);
    }

    public void deleteLocation( int locationId){
        Optional<Location> findLocation = locationRepository.findById(locationId);
        locationRepository.delete(findLocation.get());
    }



}
