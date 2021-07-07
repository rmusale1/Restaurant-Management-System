package com.egen.finalproject.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="menu_id")
    private int menuId;


    @Column(name="menu_name")
    private String menuName;

    @Column(name="menu_price")
    private int price;


   @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private Location location;





}
