package com.pavelhunko.myrentals.model;


import java.util.Date;

/**
 * Created by pavelhunko@gmail.com on 02/Sep/2015.
 */
public class Rental {


    private Integer id;
    private String street;
    private String city;
    private String state;
    private Integer monthlyRent;
    private Date moveInDate, moveOutDate;

    public Rental(Integer id, String street, String city, String state, Integer monthlyRent, Date moveInDate, Date moveOutDate) {
        this.id = id;
        this.street = street;
        this.state = state;
        this.city = city;
        this.monthlyRent = monthlyRent;
        this.moveInDate = moveInDate;
        this.moveOutDate = moveOutDate;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(Integer monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public Date getMoveInDate() {
        return moveInDate;
    }

    public void setMoveInDate(Date moveInDate) {
        this.moveInDate = moveInDate;
    }

    public Date getMoveOutDate() {
        return moveOutDate;
    }

    public void setMoveOutDate(Date moveOutDate) {
        this.moveOutDate = moveOutDate;
    }

    ;


}
