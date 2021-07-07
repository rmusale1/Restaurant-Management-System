package com.egen.finalproject.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "OpenHours")
public class OpenHours {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="open_hours_id")
    private int openHoursId;

    @Column(name="from_time")
    private String fromTime;

    @Column(name="to_time")
    private String toTime;

    @OneToOne(fetch = FetchType.LAZY)
    private Location location;




   // private locationId;


}
