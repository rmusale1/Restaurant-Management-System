/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.egen.finalproject.repository;

import com.egen.finalproject.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer> {


    @Query(value ="Select r.reservation_id,r.reservation_capacity,r.reservation_name,r.reservation_time,l.location_location_id From reservation r " +
            "inner join location_reservations l on r.reservation_id = l.reservations_reservation_id " +
            "where l.location_location_id=:id",nativeQuery = true)
    public List<Object> findReservationByLocationIddd(int id);


    @Modifying
    @Transactional
   @Query(value="Insert into location_reservations(location_location_id,reservations_reservation_id) VALUES(:reservationId,:locationId)",nativeQuery=true)
    void saveInJoinTable(int reservationId, int locationId);
}
