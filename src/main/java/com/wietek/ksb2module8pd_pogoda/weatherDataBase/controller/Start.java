package com.wietek.ksb2module8pd_pogoda.weatherDataBase.controller;

import com.wietek.ksb2module8pd_pogoda.model.Weather;
import com.wietek.ksb2module8pd_pogoda.weatherApi.controller.WeatherController;
import com.wietek.ksb2module8pd_pogoda.weatherDataBase.repo.WeatherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import java.util.Timer;
import java.util.TimerTask;

@Controller
public class Start {
    private WeatherRepo weatherRepo;
    private WeatherController weatherController;

    public Start(WeatherRepo weatherRepo, WeatherController weatherController) {
        this.weatherRepo = weatherRepo;
        this.weatherController = weatherController;
    }
    @EventListener(ApplicationReadyEvent.class)
    public void Main(){
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                weatherRepo.save(weatherController.getWeather());
                System.out.println("dodano");
            }
        };

        timer.schedule(task,0L,60*60*1000L);// 60 minut * 60 sekund * 1000 milisekund
    }
}
