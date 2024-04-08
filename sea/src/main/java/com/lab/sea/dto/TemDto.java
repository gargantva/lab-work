package com.lab.sea.dto;

import com.lab.sea.entity.TemperatureSensor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TemDto {
    private double temperature;
    private double humidness;

    public TemDto(TemperatureSensor temperatureSensor){
        this.temperature = temperatureSensor.getTemperature();
        this.humidness = temperatureSensor.getHumidity();
    }
}
