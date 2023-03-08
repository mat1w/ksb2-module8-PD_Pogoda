package com.wietek.ksb2module8pd_pogoda.weatherApi.controller;

import com.wietek.ksb2module8pd_pogoda.model.Weather;
import com.wietek.ksb2module8pd_pogoda.weatherApi.service.WeatherProvider;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

@Controller
public class WeatherController {
    WeatherProvider weatherProvider;

    public WeatherController(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }


    public Weather getWeather() {
        return weatherProvider.getWeatherByCity("Radom");
    }
}
