package com.egen.finalproject.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

   @Id
   @GeneratedValue(strategy= GenerationType.AUTO)
   @Column(name="reservation_id")
   private int reservationId;

   @Column(name="reservation_name")
   private String reservationName;

   @Column(name="reservation_time")
   private String reservationTime;

   @Column(name="reservation_capacity")
   private int reservationCapacity;

   @ManyToOne(fetch = FetchType.LAZY)
   private Location location;



}
