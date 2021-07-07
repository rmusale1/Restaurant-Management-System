package com.egen.finalproject.controller;

import com.egen.finalproject.model.Location;
import com.egen.finalproject.repository.ApiTableRepository;
import com.egen.finalproject.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationController {
   private LocationService locationService;


   public LocationController(LocationService locationService){
      this.locationService = locationService;
   }

   @Autowired
   private ApiTableRepository apiRepo;



   @RequestMapping(method = RequestMethod.GET,value ="/locations", params = {"pageNumber", "pageSize", "sortBy"})
   public ResponseEntity<Page<Location>> getAllLocations(
           @RequestParam(defaultValue ="0") int pageNo,
           @RequestParam(defaultValue="3") int pageSize,
           @RequestParam(defaultValue="locationName") String sortBy

           ){
      //List<Location> entityList =locationService.getAllLocations();

      return ResponseEntity.ok(locationService.getAllLocations(pageNo,pageSize,sortBy));
   }

   @RequestMapping(method = RequestMethod.POST,value= "/locations")
   //DTO to entity conversion method is called over here
   public  Location saveLocation(@RequestBody Location location){

      return (locationService.saveLocation(location));
   }

   @RequestMapping(method = RequestMethod.PUT,value = "/locations")
   public Location updateLocation(@RequestBody Location location)
   {
      return(locationService.updateLocation(location));
   }

   @RequestMapping(method = RequestMethod.DELETE,value = "/locations/{id}")
   public void deleteLocation(@PathVariable("id") int id){
      locationService.deleteLocation(id);

   }
   /*@RequestMapping(method = RequestMethod.GET,value = "/apiExecutionTime")
   public List<ApiTable> apiExecutionTime(){
      return ResponseEntity.ok(apiRepo. );
   }*/

   /*@RequestMapping(method = RequestMethod.DELETE,value = "/locations/{id}")
   public void deleteLocation(@PathVariable("id") int id){
      locationService.deleteLocation(id);

   }*/


}
