package com.wietek.ksb2module8pd_pogoda.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Weathers")
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String timestamp;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Weather() {
    }

    public Weather(String city, Double temperature, String timestamp) {
        this.city = city;
        this.temperature = temperature;
        this.timestamp = timestamp;
    }

    private Double temperature;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
