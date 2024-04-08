package com.lab.sea.controller;

import com.lab.sea.entity.VoltageSensor;
import com.lab.sea.service.IVoltageSensorService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/volt")
public class VoltageSensorController {
    @Resource
    private IVoltageSensorService voltageSensorService;

    @PostMapping("/save")
    public String save(@RequestBody VoltageSensor voltageSensor){
        return voltageSensorService.pushData(voltageSensor);
    }

}
