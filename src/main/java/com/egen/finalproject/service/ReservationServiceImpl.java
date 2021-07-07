/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.egen.finalproject.service;

import com.egen.finalproject.model.Reservation;
import com.egen.finalproject.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements  ReservationService{

    @Autowired
    private ReservationRepository reservationRepository;




    @Override
    public List<Object> getAllReservationsWithLocationIddd(int id) {
        return reservationRepository.findReservationByLocationIddd(id);
    }

    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void updateInJoinTable(Reservation reservation) {
        reservationRepository.saveInJoinTable(reservation.getReservationId(),reservation.getLocation().getLocationId());
    }
}
