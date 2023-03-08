package com.wietek.ksb2module8pd_pogoda.weatherDataBase.repo;

import com.wietek.ksb2module8pd_pogoda.model.Weather;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepo extends JpaRepository<Weather,Long> {

}
