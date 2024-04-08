package com.lab.sea.controller;

import com.lab.sea.entity.Device;
import com.lab.sea.entity.TemperatureSensor;
import com.lab.sea.service.IDeviceService;
import com.lab.sea.service.ITemperatureSensorService;
import jakarta.annotation.Resource;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("/tem")
public class TemperatureSensorController {
    @Resource
    private ITemperatureSensorService temperatureSensorService;


    @PostMapping("/save")
    public String saveData(@RequestBody TemperatureSensor temperatureSensor){
        return temperatureSensorService.pushData(temperatureSensor);
    }
}
