package com.egen.finalproject.model;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Location")
public class Location {

   @Id
   @GeneratedValue(strategy= GenerationType.AUTO)
   @Column(name="location_id")
    private int locationId;

   @Column(name="location_name")
    String locationName;

   @OneToMany(cascade = {CascadeType.REMOVE,CascadeType.PERSIST}, fetch=FetchType.EAGER )
   //@JoinColumn(name="Location_ID")
    private Set<Menu> menuItems;

    @OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name="Location_ID")
    private Set<Reservation> reservations;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="open_hours_id")
    private OpenHours openHours;



   @OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Reservation> reservationSlots;

   /*@OneToOne
    @JoinColumn(name="open_hours",referencedColumnName = "open_hours")
    private Openhours openhours;

    */


}
