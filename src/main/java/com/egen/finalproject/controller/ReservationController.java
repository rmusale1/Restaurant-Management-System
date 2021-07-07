package com.egen.finalproject.controller;

import com.egen.finalproject.model.Location;
import com.egen.finalproject.model.Menu;
import com.egen.finalproject.model.Reservation;
import com.egen.finalproject.repository.ApiTableRepository;
import com.egen.finalproject.repository.MenuRepository;
import com.egen.finalproject.repository.ReservationRepository;
import com.egen.finalproject.service.MenuService;
import com.egen.finalproject.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    private ReservationService reservationService;


    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Autowired
    private ApiTableRepository apiRepo;





    @RequestMapping(method = RequestMethod.GET, value = "location/{id}/reservations")
    public ResponseEntity<List<Object>> getAllReservationsWithLocationId(@PathVariable(value="id") int id) {


        return ResponseEntity.ok(reservationService.getAllReservationsWithLocationIddd(id));
    }

    @RequestMapping(method = RequestMethod.POST,value= "/location/reservation")
    public Reservation saveReservation(@RequestBody Reservation reservation){

        Reservation res = reservationService.saveReservation(reservation);
        //reservationService.updateInJoinTable(reservation);
        return (res);
    }
}
