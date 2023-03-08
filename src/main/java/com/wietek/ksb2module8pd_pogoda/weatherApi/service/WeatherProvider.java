package com.wietek.ksb2module8pd_pogoda.weatherApi.service;

import com.wietek.ksb2module8pd_pogoda.model.Weather;
import com.wietek.ksb2module8pd_pogoda.weatherApi.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class WeatherProvider {
    @Value("bfd53ff925587e7054846789693a5372")
    private String accessKey;
    RestTemplate restTemplate;
    @Autowired
    public WeatherProvider() {
        this.restTemplate = new RestTemplate();
    }


    public Weather getWeatherByCity(String city) {
        WeatherResponse response = restTemplate.getForObject(String.format("http://api.weatherstack.com/current?access_key=%s&query=%s", accessKey, city), WeatherResponse.class);
        return new Weather(response.getLocation().getName(), response.getCurrent().getTemperature(), response.getLocation().getLocaltime());

    }
}
